package edu.uade.sam.service;

import java.util.Collection;
import java.util.Map;

import Result.ResultStudent;
import edu.uade.sam.model.ResultAnova;

public interface CalculatorService {

	/**
	 * A single factor or one-way ANOVA is used to test the null hypothesis that
	 * the means of several populations are all equal.
	 * 
	 * H0: μ1 = μ2 = μ3 H1: at least one of the means is different.
	 * 
	 * @param data
	 * @return
	 */
	ResultAnova performOneWayAnova(Map<String, double[]> groups);

	/**
	 * The t-Test is used to test the null hypothesis that the means of two
	 * populations are equal.
	 * 
	 * H0: μ1 - μ2 = 0 H1: μ1 - μ2 ≠ 0
	 * 
	 * @param data
	 * @return
	 */
	ResultStudent PerformStudentT(Collection<double[]> data);

}
