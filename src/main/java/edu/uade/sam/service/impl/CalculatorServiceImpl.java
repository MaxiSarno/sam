package edu.uade.sam.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.OneWayAnova;
import org.apache.commons.math3.util.Pair;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.service.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	private Map<Pair<String, String>, SummaryStatistics> collect(
			List<NumericAttribute> attributes) {
		Map<Pair<String, String>, SummaryStatistics> collection = new HashMap<>();

		for (NumericAttribute a : attributes) {
			Pair<String, String> key = new Pair<>(a.getProduct(),
					a.getAttribute());

			if (!collection.containsKey(key)) {
				collection.put(key, new SummaryStatistics());
			}

			collection.get(key).addValue(a.getValue());
		}

		return collection;
	}

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

	private void doStuff(List<NumericAttribute> attributes) {
		Map<Pair<String, String>, SummaryStatistics> c = this
				.collect(attributes);
	}

	@Override
	public void performAnova(SummaryStatistics... a) {
		// TODO Auto-generated method stub
		
	}

	// anova
//	public double getAnovaPValue(Collection<double[]> categoryData) {
//		OneWayAnova a = new OneWayAnova();
//		a.anovaTest(categoryData, alpha);
//		return a.anovaPValue(categoryData);
//	}
//
//	public double getAnovaFValue() {
//		OneWayAnova a = new OneWayAnova();
//		return a.anovaFValue(categoryData)
//	}

}
