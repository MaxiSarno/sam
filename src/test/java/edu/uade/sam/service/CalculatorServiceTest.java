package edu.uade.sam.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Result.ResultStudent;
import edu.uade.sam.model.ResultAnova;
import edu.uade.sam.service.impl.CalculatorServiceImpl;
import edu.uade.sam.utils.csv.CSVParser;

public class CalculatorServiceTest {

	@Autowired
	CSVParser csvParser;

	CalculatorService calculatorService = new CalculatorServiceImpl();

	@Test
	public void performOneWayAnova_pValue_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova p-value", 7.16E-5, r.getpValue(), 0.00001);
	}

	@Test
	public void performOneWayAnova_fValue_ok() {

		// List<Integer> valuesA = Arrays.asList(42, 53, 49, 53, 43, 44, 45, 52,
		// 54);
		// List<Integer> valuesB = Arrays.asList(69, 54, 58, 64, 64, 55, 56);
		// List<Integer> valuesC = Arrays.asList(35, 40, 53, 42, 50, 39, 55, 39,
		// 40);
		//
		// List<NumericAttribute> aAttributes = this.mockAttributes("Economics",
		// valuesA);
		// List<NumericAttribute> bAttributes = this.mockAttributes("Medicime",
		// valuesB);
		// List<NumericAttribute> cAttributes = this.mockAttributes("History",
		// valuesC);
		//
		// SummaryStatistics sA = new SummaryStatistics();
		// aAttributes.stream().map(a -> a.getValue().doubleValue()).forEach(v
		// -> sA.addValue(v));
		// SummaryStatistics sB = new SummaryStatistics();
		// bAttributes.stream().map(a -> a.getValue().doubleValue()).forEach(v
		// -> sB.addValue(v));
		// SummaryStatistics sC = new SummaryStatistics();
		// cAttributes.stream().map(a -> a.getValue().doubleValue()).forEach(v
		// -> sC.addValue(v));

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova Fvalue", 15.19623, r.getfValue(), 0.00001);
	}

	@Test
	public void performOneWayAnova_fCritValue_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova fCritvalue", 3.443357, r.getfCritValue(),
				0.00001);
	}

	@Test
	public void performOneWayAnova_testValue_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova test value", true, r.isRejectH0());
	}

	@Test
	public void performOneWayAnova_resultSummary_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertNotNull("anova result summaries", r.getSummaries());
		Assert.assertEquals("anova result summaries", 3, r.getSummaries()
				.size());
	}

	@Test
	public void performOneWayAnova_resultSummaryCount_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova result summary a class count", 9, r
				.getSummaries().get(0).getCount());
		Assert.assertEquals("anova result summary a class count", 7, r
				.getSummaries().get(1).getCount(), 0.00001);
		Assert.assertEquals("anova result summary a class count", 9, r
				.getSummaries().get(2).getCount(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummarySum_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova result summary a class sum", 435, r
				.getSummaries().get(0).getSum(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 420, r
				.getSummaries().get(1).getSum(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 393, r
				.getSummaries().get(2).getSum(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummaryAverage_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova result summary a class average", 48.33333, r
				.getSummaries().get(0).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary a class average", 60, r
				.getSummaries().get(1).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary a class average", 43.66667, r
				.getSummaries().get(2).getAverage(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummaryVariance_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		ResultAnova r = calculatorService.performOneWayAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova result summary a class variance", 23.5, r
				.getSummaries().get(0).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary a class variance", 32.33333,
				r.getSummaries().get(1).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary a class variance", 50.5, r
				.getSummaries().get(2).getVariance(), 0.00001);
	}
	
	@Test
	public void performStudentT_alala() {
		double[] a = { 26, 25, 43, 34, 18, 52 };
		double[] b = { 23, 30, 18, 25, 28 };
		
		ResultStudent r = calculatorService.PerformStudentT(Arrays.asList(a, b));
		
		
	}

	// @Test
	// public void calculate_tStudent_ok() throws FileNotFoundException,
	// IOException {
	// List<NumericAttribute> attributes = this.csvParser.parseNumeric(this
	// .mockFile());
	// }
	//
	// private List<NumericAttribute> mockAttributes(String product,
	// List<Integer> values) {
	// String attribute = "attribute";
	//
	// return values.stream()
	// .map(v -> (new NumericAttribute(product, attribute, v)))
	// .collect(Collectors.toList());
	// }
	//
	// private MultipartFile mockFile() throws FileNotFoundException,
	// IOException {
	// File f = new File("src/test/resources/hedonic-attributes-sample.csv");
	// InputStream in = new FileInputStream(f);
	// MultipartFile file = new MockMultipartFile("tuvieja", in);
	// return file;
	// }

}
