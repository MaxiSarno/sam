package edu.uade.sam.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import edu.uade.sam.model.PartialResult;
import edu.uade.sam.service.CalculatorService;

/**
 * Selects the method to be used to test the null hypothesis based on the amount
 * of samples
 * 
 * H0: equal μ for all populations H1: μ not equal
 * 
 * @author msarno
 *
 */
@Component("CalculatorServiceSelector")
public class CalculatorServiceSelector implements CalculatorService {

	@Autowired
	private CalculatorServiceAnova anova;

	@Autowired
	private CalculatorServiceStudentT studentT;
	
	@Autowired
	private CalculatorServiceBasic basic;

	@Override
	public PartialResult calculate(Map<String, double[]> groups, float alpha) {
		if (1 == groups.entrySet().size()) {
			return basic.calculate(groups, alpha);
		} else if (2 == groups.entrySet().size()) {
			return studentT.calculate(groups, alpha);
		}

		return anova.calculate(groups, alpha);
	}

	@VisibleForTesting
	public void setAnova(CalculatorServiceAnova anova) {
		this.anova = anova;
	}

	@VisibleForTesting
	public void setStudentT(CalculatorServiceStudentT studentT) {
		this.studentT = studentT;
	}

	@VisibleForTesting
	public void setBasic(CalculatorServiceBasic basic) {
		this.basic = basic;
	}

}
