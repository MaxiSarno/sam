package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import edu.uade.sam.model.Distribution;
import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.CalculatorService;
import edu.uade.sam.service.ResultsService;

@Component
public class ResultsServiceImpl implements ResultsService {
	
	private static final float ALPHA = 0.05f;

	private Map<Integer, Result> resultsDao;
	
	@Autowired
	private AttributesService attributesService;
	
	@Autowired
	private CalculatorService calculatorService;
	
	@PostConstruct
	public void init() {
		resultsDao = new HashMap<>();
	}

	
	@Override
	public Result get(Integer testId) {
		if (!resultsDao.containsKey(testId)) {
			this.generate(testId);
		}
		
		return resultsDao.get(testId);
	}

	@Override
	public Result generate(Integer testId) {
		//FIXME validar que exista test
		
		//FIXME no castear
		List<NumericAttribute> attributes = (List<NumericAttribute>) attributesService.get(testId);
		
		Table<String, String, List<Double>> groupsD = this.groupAttributes(attributes);
		
		for (String rowKey : groupsD.rowKeySet()) {
			
			Map<String, double[]> groups = new HashMap<>();
			for (Entry<String, List<Double>> e : groupsD.row(rowKey).entrySet()) {
				groups.put(e.getKey(), e.getValue().stream().mapToDouble(d->d).toArray());
			}

			Result r = this.getResult(groups, ALPHA);
		}
		
		
		return null;
	}


	private Result getResult(Map<String, double[]> groups, float alpha) {
		Distribution d = this.chooseDistribution(groups);
		
		if (Distribution.ANOVA == d) {
			return this.calculatorService.performOneWayAnova(groups, alpha);
		}
		
		return this.calculatorService.performStudentT(groups, alpha);
	}


	private Distribution chooseDistribution(Map<String, double[]> groups) {
		if (2 == groups.entrySet().size()) {
			return Distribution.STUDENT_T;
		}
		
		return Distribution.ANOVA;
	}


	// row:Attribute, column:Product, cell:Values
	private Table<String, String, List<Double>> groupAttributes(List<NumericAttribute> attributes) {
		Table<String, String, List<Double>> groups = HashBasedTable.create();
		
		for (NumericAttribute a : attributes) {			
			if (!groups.contains(a.getAttribute(), a.getProduct())) {
				groups.put(a.getAttribute(), a.getProduct(), new ArrayList<>());
			}
			groups.get(a.getAttribute(), a.getProduct()).add(a.getValue().doubleValue());
		}
		
		return groups;
	}

}
