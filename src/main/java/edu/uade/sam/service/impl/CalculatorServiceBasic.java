package edu.uade.sam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.uade.sam.model.Distribution;
import edu.uade.sam.model.PartialResult;
import edu.uade.sam.model.ResultSummary;
import edu.uade.sam.service.CalculatorService;

@Component("CalculatorServiceBasic")
public class CalculatorServiceBasic implements CalculatorService {

	@Override
	public PartialResult calculate(String attributeName, Map<String, double[]> groups, float alpha) {
		List<ResultSummary> summaries = calculateSummaries(groups);
		
		return new PartialResult(attributeName, Distribution.NONE, false, summaries);
	}

}
