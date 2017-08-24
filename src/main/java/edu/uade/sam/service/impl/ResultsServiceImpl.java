package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.CalculatorService;
import edu.uade.sam.service.ResultsService;

@Component
public class ResultsServiceImpl implements ResultsService {

	private Map<Integer, Result> resultsDao = new HashMap<>();
	
	@Autowired
	private AttributesService attributesService;

	@Autowired
	@Qualifier("CalculatorServiceSelector")
	private CalculatorService calculatorService;

	@Override
	public Result get(long samId) {
		if (!resultsDao.containsKey(samId)) {
			return null;
		}

		return resultsDao.get(samId);
	}

	@Override
	public Result generate(long samId, float alpha) {
		List<NumericAttribute> attributes = attributesService.get(samId);

		if (null == attributes) {
			return null;
		}

		Result r = new Result(samId, alpha);

		Table<String, String, List<Double>> groupsD = this.groupAttributes(attributes);

		for (String attributeName : groupsD.rowKeySet()) {

			Map<String, double[]> groups = new HashMap<>();
			for (Entry<String, List<Double>> e : groupsD.row(attributeName).entrySet()) {
				groups.put(e.getKey(), e.getValue().stream().mapToDouble(d -> d).toArray());
			}

			r.getPartialResults().add(this.calculatorService.calculate(attributeName, groups, alpha));
		}

		return r;
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

	@VisibleForTesting
	public void setAttributesService(AttributesService a) {
		this.attributesService = a;
	}

	@VisibleForTesting
	public void setCalculatorService(CalculatorService c) {
		this.calculatorService = c;
	}
}
