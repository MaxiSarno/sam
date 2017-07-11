package edu.uade.sam.service.impl;

import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.ImmutableMap;

import edu.uade.sam.model.PartialResultAnova;
import edu.uade.sam.service.CalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceAnovaTest {

	@Autowired
	@Qualifier("CalculatorServiceAnova")
	CalculatorService calculatorService;

	static Map<String, double[]> threeGroups;

	@BeforeClass
	public static void init() {
		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		threeGroups = ImmutableMap.of("economics", a, "medicine", b, "history", c);
 	}

	@Test
	public void calculate_pValue_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);
		Assert.assertEquals("anova p-value", 7.16E-5, r.getpValue(), 0.00001);
	}

	@Test
	public void calculate_fValue_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);
		Assert.assertEquals("anova Fvalue", 15.19623, r.getfValue(), 0.00001);
	}

	@Test
	public void calculate_testValue_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);
		Assert.assertEquals("anova test value", true, r.getAreDifferent());
	}
	
	//TODO test one group

}
