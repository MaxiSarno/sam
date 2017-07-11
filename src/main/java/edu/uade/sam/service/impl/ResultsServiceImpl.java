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
import edu.uade.sam.service.SensoryEvaluationService;

@Component
public class ResultsServiceImpl implements ResultsService {

	private Map<Integer, Result> resultsDao = new HashMap<>();

	@Autowired
	private AttributesService attributesService;

	@Autowired
	private SensoryEvaluationService sensoryEvaluationService;

	@Autowired
	@Qualifier("CalculatorServiceSelector")
	private CalculatorService calculatorService;

	@Override
	public Result get(Integer testId) {
		if (!resultsDao.containsKey(testId)) {
			return null;
		}

		return resultsDao.get(testId);
	}

	@Override
	public Result generate(Integer testId, float alpha) {
		if (null == this.sensoryEvaluationService.get(testId)) {
			return null;
		}

		Result r = new Result(alpha);

		List<NumericAttribute> attributes = attributesService.get(testId);

		Table<String, String, List<Double>> groupsD = this.groupAttributes(attributes);

		for (String rowKey : groupsD.rowKeySet()) {

			Map<String, double[]> groups = new HashMap<>();
			for (Entry<String, List<Double>> e : groupsD.row(rowKey).entrySet()) {
				groups.put(e.getKey(), e.getValue().stream().mapToDouble(d -> d).toArray());
			}

			r.getPartialResults().add(this.calculatorService.calculate(groups, alpha));
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

	@VisibleForTesting
	public void setSensoryEvaluationService(SensoryEvaluationService sensoryEvaluationService) {
		this.sensoryEvaluationService = sensoryEvaluationService;
	}
}
