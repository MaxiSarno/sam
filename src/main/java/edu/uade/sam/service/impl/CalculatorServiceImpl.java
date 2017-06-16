package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.OneWayAnova;
import org.apache.commons.math3.stat.inference.TTest;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.PartialResultAnova;
import edu.uade.sam.model.PartialResultStudent;
import edu.uade.sam.model.ResultSummary;
import edu.uade.sam.service.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public PartialResultAnova performOneWayAnova(Map<String, double[]> groups, float alpha) {

		if (groups.size() < 3)
			throw new RuntimeException();

		PartialResultAnova r = new PartialResultAnova();
		OneWayAnova owa = new OneWayAnova();

		r.setpValue(owa.anovaPValue(groups.values()));
		r.setfValue(owa.anovaFValue(groups.values()));
		// r.setfCritValue();
		r.setAreDifferent(owa.anovaTest(groups.values(), alpha));
		r.setSummaries(calculateSummaries(groups));

		return r;
	}

	@Override
	public PartialResultStudent performStudentT(Map<String, double[]> groups, float alpha) {
		PartialResultStudent r = new PartialResultStudent();
		r.setSummaries(this.calculateSummaries(groups));
		TTest t = new TTest();
		Iterator<double[]> i = groups.values().iterator();
		double[] sample1 = i.next();
		double[] sample2 = i.next();

//		double t1 = t.pairedT(sample1, sample2);
//		System.out.println(t1);
//		double t2 = t.pairedTTest(sample1, sample2);
//		System.out.println(t2);
//		boolean t3 = t.pairedTTest(sample1, sample2, 0.05);
//		System.out.println(t3);
		
		SummaryStatistics stats = new SummaryStatistics();
		Arrays.stream(sample1).forEach(v -> stats.addValue(v));
		Arrays.stream(sample2).forEach(v -> stats.addValue(v));
		System.out.println(calcMeanCI(stats, alpha));

		return r;
	}

	private List<ResultSummary> calculateSummaries(Map<String, double[]> groups) {
		List<ResultSummary> summaries = new ArrayList<>();

		for (Entry<String, double[]> group : groups.entrySet()) {
			SummaryStatistics s = new SummaryStatistics();
			Arrays.stream(group.getValue()).forEach(v -> s.addValue(v));
			summaries.add(new ResultSummary(group.getKey(), s.getN(), s.getSum(), s.getMin(), s.getMax(), s.getMean(),
					s.getVariance()));
		}

		return summaries;
	}

	// Student T
	private static double calculateXCrit1(SummaryStatistics stats, double alpha) {
		return (stats.getMean() - calcMeanCI(stats, alpha));
	}

	private static double calculateXCrit2(SummaryStatistics stats, double alpha) {
		return (stats.getMean() + calcMeanCI(stats, alpha));
	}

	//
	// t * s/SQRT(n)
	private static double calcMeanCI(SummaryStatistics stats, double alpha) {
		try {
			// Create T Distribution with N-1 degrees of freedom
			TDistribution tDist = new TDistribution(stats.getN() - 1);
			// Calculate critical value
			double tVal = tDist.inverseCumulativeProbability(1.0 - alpha / 2);
			// Calculate confidence interval
			return tVal * stats.getStandardDeviation() / Math.sqrt(stats.getN());
		} catch (MathIllegalArgumentException e) {
			return Double.NaN;
		}
	}

}
