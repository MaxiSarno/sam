package edu.uade.sam.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.inference.TTest;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.PartialResult;
import edu.uade.sam.model.PartialResultStudent;
import edu.uade.sam.model.ResultSummary;
import edu.uade.sam.service.CalculatorService;

/**
 * The t-Test is used to test the null hypothesis that the means of two
 * populations are equal.
 * 
 * H0: μ1 - μ2 = 0 
 * H1: μ1 - μ2 ≠ 0
 * 
 * @author msarno
 *
 */
@Component("CalculatorServiceStudentT")
public class CalculatorServiceStudentT implements CalculatorService {

	@Override
	public PartialResult calculate(String attributeName, Map<String, double[]> groups, float alpha) {
		TTest t = new TTest();

		Iterator<double[]> i = groups.values().iterator();
		double[] sample1 = i.next();
		double[] sample2 = i.next();
		boolean areDifferent = t.pairedTTest(sample1, sample2, alpha);
		List<ResultSummary> summaries = calculateSummaries(groups);
		String winner = this.findWinner(areDifferent, summaries);

		return new PartialResultStudent(attributeName, areDifferent, winner, summaries);
		
		// double t1 = t.pairedT(sample1, sample2);
		// System.out.println(t1);
		// double t2 = t.pairedTTest(sample1, sample2);
		// System.out.println(t2);

		// SummaryStatistics stats = new SummaryStatistics();
		// Arrays.stream(sample1).forEach(v -> stats.addValue(v));
		// Arrays.stream(sample2).forEach(v -> stats.addValue(v));
		// System.out.println(calcMeanCI(stats, alpha));
	}
	


	private String findWinner(boolean areDifferent, List<ResultSummary> summaries) {
		String winner = "iguales";
		double best = 0;
		
		if(!areDifferent) {
			return winner;
		}
		
		for (ResultSummary r : summaries) {
			if (r.getAverage() > best) {
				winner = r.getSampleName();
				best = r.getAverage();
			}
		}
		
		return winner;
	}

	// Student T
	// private static double calculateXCrit1(SummaryStatistics stats, double
	// alpha) {
	// return (stats.getMean() - calcMeanCI(stats, alpha));
	// }
	//
	// private static double calculateXCrit2(SummaryStatistics stats, double
	// alpha) {
	// return (stats.getMean() + calcMeanCI(stats, alpha));
	// }
	//
	// t * s/SQRT(n)
	// private static double calcMeanCI(SummaryStatistics stats, double alpha) {
	// try {
	// // Create T Distribution with N-1 degrees of freedom
	// TDistribution tDist = new TDistribution(stats.getN() - 1);
	// // Calculate critical value
	// double tVal = tDist.inverseCumulativeProbability(1.0 - alpha / 2);
	// // Calculate confidence interval
	// return tVal * stats.getStandardDeviation() / Math.sqrt(stats.getN());
	// } catch (MathIllegalArgumentException e) {
	// return Double.NaN;
	// }
	// }

}
