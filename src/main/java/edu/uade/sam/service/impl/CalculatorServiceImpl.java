package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.OneWayAnova;
import org.apache.commons.math3.stat.inference.TTest;
import org.springframework.stereotype.Component;

import Result.ResultStudent;
import edu.uade.sam.model.ResultAnova;
import edu.uade.sam.model.ResultSummary;
import edu.uade.sam.service.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public ResultAnova performOneWayAnova(Map<String, double[]> groups) {

		if (groups.size() < 3)
			throw new RuntimeException();

		ResultAnova r = new ResultAnova();
		OneWayAnova owa = new OneWayAnova();

		r.setpValue(owa.anovaPValue(groups.values()));
		r.setfValue(owa.anovaFValue(groups.values()));
		// r.setfCritValue();
		r.setRejectH0(owa.anovaTest(groups.values(), 0.05));
		r.setSummaries(new ArrayList<>());

		for(Entry<String, double[]> e : groups.entrySet()) {
			SummaryStatistics s = new SummaryStatistics();
			Arrays.stream(e.getValue()).forEach(v -> s.addValue(v));
			r.getSummaries().add(new ResultSummary(e.getKey(), s.getN(), s.getSum(), s.getMin(), s.getMax(), s.getMean(), s.getVariance()));
		}

		return r;
	}

	@Override
	public ResultStudent PerformStudentT(Collection<double[]> data) {
		TTest t = new TTest();
		return null;
	}

	// // Student T
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
	// //
	// // t * s/SQRT(n)
	// private static double calcMeanCI(SummaryStatistics stats, double alpha) {
	// try {
	// // Create T Distribution with N-1 degrees of freedom
	// TDistribution tDist = new TDistribution(stats.getN() - 1);
	// // Calculate critical value
	// double tVal = tDist.inverseCumulativeProbability(1.0 - alpha / 2);
	// // Calculate confidence interval
	// return tVal * stats.getStandardDeviation()
	// / Math.sqrt(stats.getN());
	// } catch (MathIllegalArgumentException e) {
	// return Double.NaN;
	// }
	// }

}
