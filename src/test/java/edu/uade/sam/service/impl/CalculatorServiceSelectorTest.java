package edu.uade.sam.service.impl;

import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.ImmutableMap;

import edu.uade.sam.model.PartialResult;
import edu.uade.sam.service.CalculatorService;

/**
 * @author msarno
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceSelectorTest {

	private static final float ALPHA = 0.05f;
	private static final String ATTRIBUTE_NAME = "Careers";

	@Autowired
	@Qualifier("CalculatorServiceSelector")
	CalculatorService calculatorService;

	static Map<String, double[]> threeGroups, twoGroups, oneGroup;

	@BeforeClass
	public static void init() {
		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		threeGroups = ImmutableMap.of("economics", a, "medicine", b, "history", c);
		twoGroups = ImmutableMap.of("economics", a, "history", c);
		oneGroup = ImmutableMap.of("medicine", b);
	}

	@Test
	public void calculate_resultSummary_ok() {
		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertNotNull("anova result summaries", r.getSummaries());
		Assert.assertEquals("anova result summaries", 3, r.getSummaries().size());
	}

	@Test
	public void calculate_resultSummaryName_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary count", "economics", r.getSummaries().get(0).getSampleName());
		Assert.assertEquals("anova result summary count", "medicine", r.getSummaries().get(1).getSampleName());
		Assert.assertEquals("anova result summary count", "history", r.getSummaries().get(2).getSampleName());
	}

	@Test
	public void calculate_resultSummaryCount_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary count", 9, r.getSummaries().get(0).getCount());
		Assert.assertEquals("anova result summary count", 7, r.getSummaries().get(1).getCount(), 0.00001);
		Assert.assertEquals("anova result summary count", 9, r.getSummaries().get(2).getCount(), 0.00001);
	}

	@Test
	public void calculate_resultSummarySum_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary sum", 435, r.getSummaries().get(0).getSum(), 0.00001);
		Assert.assertEquals("anova result summary sum", 420, r.getSummaries().get(1).getSum(), 0.00001);
		Assert.assertEquals("anova result summary sum", 393, r.getSummaries().get(2).getSum(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryMax_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary sum", 54, r.getSummaries().get(0).getMax(), 0.00001);
		Assert.assertEquals("anova result summary sum", 69, r.getSummaries().get(1).getMax(), 0.00001);
		Assert.assertEquals("anova result summary sum", 55, r.getSummaries().get(2).getMax(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryMin_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary sum", 42, r.getSummaries().get(0).getMin(), 0.00001);
		Assert.assertEquals("anova result summary sum", 54, r.getSummaries().get(1).getMin(), 0.00001);
		Assert.assertEquals("anova result summary sum", 35, r.getSummaries().get(2).getMin(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryAverage_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary average", 48.33333, r.getSummaries().get(0).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary average", 60, r.getSummaries().get(1).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary average", 43.66667, r.getSummaries().get(2).getAverage(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryVariance_ok() {

		PartialResult r = calculatorService.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);

		Assert.assertEquals("anova result summary variance", 23.5, r.getSummaries().get(0).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary variance", 32.33333, r.getSummaries().get(1).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary variance", 50.5, r.getSummaries().get(2).getVariance(), 0.00001);
	}

	@Test
	public void calculate_oneGroup_basic() {
		CalculatorServiceSelector c = new CalculatorServiceSelector();
		CalculatorServiceBasic basic = Mockito.mock(CalculatorServiceBasic.class);
		CalculatorServiceStudentT studentT = Mockito.mock(CalculatorServiceStudentT.class);
		c.setBasic(basic);
		c.setStudentT(studentT);
		
		c.calculate(ATTRIBUTE_NAME, oneGroup, ALPHA);
		
		Mockito.verify(basic).calculate(ATTRIBUTE_NAME, oneGroup, ALPHA);
	}

	@Test
	public void calculate_twoGroups_studentT() {
		CalculatorServiceSelector c = new CalculatorServiceSelector();
		CalculatorServiceAnova anova = Mockito.mock(CalculatorServiceAnova.class);
		CalculatorServiceStudentT studentT = Mockito.mock(CalculatorServiceStudentT.class);
		c.setAnova(anova);
		c.setStudentT(studentT);
		
		c.calculate(ATTRIBUTE_NAME, twoGroups, ALPHA);
		
		Mockito.verify(studentT).calculate(ATTRIBUTE_NAME, twoGroups, ALPHA);
	}

	@Test
	public void calculate_threeGroups_anova() {
		CalculatorServiceSelector c = new CalculatorServiceSelector();
		CalculatorServiceAnova anova = Mockito.mock(CalculatorServiceAnova.class);
		CalculatorServiceStudentT studentT = Mockito.mock(CalculatorServiceStudentT.class);
		c.setAnova(anova);
		c.setStudentT(studentT);
		
		c.calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);
		
		Mockito.verify(anova).calculate(ATTRIBUTE_NAME, threeGroups, ALPHA);
	}

}
