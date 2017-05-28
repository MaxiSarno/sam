package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Collection;

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
	public ResultAnova performOneWayAnova(Collection<double[]> groups) {

		if (groups.size() < 3)
			throw new RuntimeException();

		ResultAnova r = new ResultAnova();
		OneWayAnova owa = new OneWayAnova();

		r.setpValue(owa.anovaPValue(groups));
		r.setfValue(owa.anovaFValue(groups));
		// r.setfCritValue();
		r.setRejectH0(owa.anovaTest(groups, 0.05));
		r.setSummaries(new ArrayList<>());

		for (double[] g : groups) {
			SummaryStatistics s = new SummaryStatistics();
			for (int i = 0; i < g.length; i++) {
				s.addValue(g[i]);
			}
			r.getSummaries().add(new ResultSummary(s.getN(), s.getSum(), s.getMean(), s.getVariance()));
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
