package edu.uade.sam.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.inference.OneWayAnova;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.PartialResult;
import edu.uade.sam.model.PartialResultAnova;
import edu.uade.sam.model.ResultSummary;
import edu.uade.sam.service.CalculatorService;

/**
 * A single factor or one-way ANOVA is used to test the null hypothesis that
 * the means of several populations are all equal.
 * 
 * H0: μ1 = μ2 = μ3 = ... = μn
 * H1: at least one of the means is different.
 * 
 * @author msarno
 *
 */
@Component("CalculatorServiceAnova")
public class CalculatorServiceAnova implements CalculatorService {

	@Override
	public PartialResult calculate(String attributeName, Map<String, double[]> groups, float alpha) {
		if (groups.size() == 2) {
			throw new RuntimeException();
		}

		OneWayAnova owa = new OneWayAnova();

		boolean areDifferent = owa.anovaTest(groups.values(), alpha);
		List<ResultSummary> summaries = calculateSummaries(groups);
		double fValue = owa.anovaFValue(groups.values());
		double fCritValue = 0;
		double pValue = owa.anovaPValue(groups.values());
		String winner = this.findWinner(areDifferent, summaries);

		return new PartialResultAnova(attributeName, areDifferent, winner, summaries, fValue, fCritValue, pValue);
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

}
