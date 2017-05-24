package edu.uade.sam.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.OneWayAnova;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.Result;
import edu.uade.sam.service.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	// one way anova
	@Override
	public Result performAnova(Collection<double[]> data) {
		Result r = new Result();
		OneWayAnova owa = new OneWayAnova();

		r.setpValue(owa.anovaPValue(data));
		r.setfValue(owa.anovaFValue(data));
		//r.setfCritValue();
		r.setTestValue(owa.anovaTest(data, 0.05));

		return r;
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
			return tVal * stats.getStandardDeviation()
					/ Math.sqrt(stats.getN());
		} catch (MathIllegalArgumentException e) {
			return Double.NaN;
		}
	}

}
