package edu.uade.sam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import edu.uade.sam.model.PartialResult;
import edu.uade.sam.model.ResultSummary;

/**
 * @author msarno
 *
 */
public interface CalculatorService {
	
	/**
	 * Calculates the result of the test given n groups and an error tolerance
	 * 
	 * @param groups
	 * @param alpha
	 * @return
	 */
	PartialResult calculate(Map<String, double[]> groups, float alpha);
	
	default List<ResultSummary> calculateSummaries(Map<String, double[]> groups) {
		List<ResultSummary> summaries = new ArrayList<>();

		for (Entry<String, double[]> group : groups.entrySet()) {
			SummaryStatistics s = new SummaryStatistics();
			Arrays.stream(group.getValue()).forEach(v -> s.addValue(v));
			summaries.add(new ResultSummary(group.getKey(), s.getN(), s.getSum(), s.getMin(), s.getMax(), s.getMean(),
					s.getVariance()));
		}

		return summaries;
	}

}
