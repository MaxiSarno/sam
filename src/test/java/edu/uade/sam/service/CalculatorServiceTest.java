package edu.uade.sam.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
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
	
	static Map<String, double[]> twoGroups;
	static Map<String, double[]> threeGroups;
	
	@BeforeClass
	public static void init() {
		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };
		
		twoGroups = new HashMap<>();
		twoGroups.put("economics", a);
		twoGroups.put("medicine", b);
		
		threeGroups = new HashMap<>();
		threeGroups.put("economics", a);
		threeGroups.put("medicine", b);
		threeGroups.put("history", c);
	}

	@Test(expected = RuntimeException.class)
	public void performOneWayAnova_twogroups_error() {

		calculatorService.performOneWayAnova(twoGroups);

		Assert.fail();
	}
	
	@Test
	public void performOneWayAnova_pValue_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova p-value", 7.16E-5, r.getpValue(), 0.00001);
	}

	@Test
	public void performOneWayAnova_fValue_ok() {

		// List<Integer> valuesA = Arrays.asList(42, 53, 49, 53, 43, 44, 45, 52,
		// 54);
		//
		// List<NumericAttribute> aAttributes = this.mockAttributes("Economics",
		// valuesA);
		//
		// SummaryStatistics sA = new SummaryStatistics();
		// aAttributes.stream().map(a -> a.getValue().doubleValue()).forEach(v
		// -> sA.addValue(v));

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova Fvalue", 15.19623, r.getfValue(), 0.00001);
	}

	@Test
	public void performOneWayAnova_fCritValue_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova fCritvalue", 3.443357, r.getfCritValue(),
				0.00001);
	}

	@Test
	public void performOneWayAnova_testValue_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova test value", true, r.isRejectH0());
	}

	@Test
	public void performOneWayAnova_resultSummary_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertNotNull("anova result summaries", r.getSummaries());
		Assert.assertEquals("anova result summaries", 3, r.getSummaries()
				.size());
	}

	@Test
	public void performOneWayAnova_resultSummaryName_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class count", "economics", r
				.getSummaries().get(0).getName());
		Assert.assertEquals("anova result summary a class count", "medicine", r
				.getSummaries().get(1).getName());
		Assert.assertEquals("anova result summary a class count", "history", r
				.getSummaries().get(2).getName());
	}

	@Test
	public void performOneWayAnova_resultSummaryCount_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class count", 9, r
				.getSummaries().get(0).getCount());
		Assert.assertEquals("anova result summary a class count", 7, r
				.getSummaries().get(1).getCount(), 0.00001);
		Assert.assertEquals("anova result summary a class count", 9, r
				.getSummaries().get(2).getCount(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummarySum_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class sum", 435, r
				.getSummaries().get(0).getSum(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 420, r
				.getSummaries().get(1).getSum(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 393, r
				.getSummaries().get(2).getSum(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummaryMax_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class sum", 54, r
				.getSummaries().get(0).getMax(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 69, r
				.getSummaries().get(1).getMax(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 55, r
				.getSummaries().get(2).getMax(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummaryMin_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class sum", 42, r
				.getSummaries().get(0).getMin(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 54, r
				.getSummaries().get(1).getMin(), 0.00001);
		Assert.assertEquals("anova result summary a class sum", 35, r
				.getSummaries().get(2).getMin(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummaryAverage_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class average", 48.33333, r
				.getSummaries().get(0).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary a class average", 60, r
				.getSummaries().get(1).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary a class average", 43.66667, r
				.getSummaries().get(2).getAverage(), 0.00001);
	}

	@Test
	public void performOneWayAnova_resultSummaryVariance_ok() {

		ResultAnova r = calculatorService.performOneWayAnova(threeGroups);

		Assert.assertEquals("anova result summary a class variance", 23.5, r
				.getSummaries().get(0).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary a class variance", 32.33333,
				r.getSummaries().get(1).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary a class variance", 50.5, r
				.getSummaries().get(2).getVariance(), 0.00001);
	}
	
	@Test
	public void performStudentT_alala() {

		ResultStudent r = calculatorService.performStudentT(twoGroups);
		
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
