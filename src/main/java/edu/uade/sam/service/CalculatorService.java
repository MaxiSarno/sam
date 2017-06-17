package edu.uade.sam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import edu.uade.sam.model.PartialResult;
import edu.uade.sam.model.ResultSummary;

public interface CalculatorService {
	
	/**
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

	/**
	 * A single factor or one-way ANOVA is used to test the null hypothesis that
	 * the means of several populations are all equal.
	 * 
	 * H0: μ1 = μ2 = μ3 = ... = μn
	 * H1: at least one of the means is different.
	 * 
	 * @param groups
	 * @param alpha
	 * @return
	 */
//	PartialResultAnova performOneWayAnova(Map<String, double[]> groups, float alpha);

	/**
	 * The t-Test is used to test the null hypothesis that the means of two
	 * populations are equal.
	 * 
	 * H0: μ1 - μ2 = 0 
	 * H1: μ1 - μ2 ≠ 0
	 * 
	 * @param groups
	 * @param alpha
	 * @return
	 */
//	PartialResultStudent performStudentT(Map<String, double[]> groups, float alpha);

}
