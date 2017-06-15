package edu.uade.sam.service;

import java.util.Map;

import edu.uade.sam.model.ResultAnova;
import edu.uade.sam.model.ResultStudent;

public interface CalculatorService {

	/**
	 * A single factor or one-way ANOVA is used to test the null hypothesis that
	 * the means of several populations are all equal.
	 * 
	 * H0: μ1 = μ2 = μ3 H1: at least one of the means is different.
	 * 
	 * @param groups
	 * @param alpha
	 * @return
	 */
	ResultAnova performOneWayAnova(Map<String, double[]> groups, float alpha);

	/**
	 * The t-Test is used to test the null hypothesis that the means of two
	 * populations are equal.
	 * 
	 * H0: μ1 - μ2 = 0 H1: μ1 - μ2 ≠ 0
	 * 
	 * @param groups
	 * @param alpha
	 * @return
	 */
	ResultStudent performStudentT(Map<String, double[]> groups, float alpha);

}
