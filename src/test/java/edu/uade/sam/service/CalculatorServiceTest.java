package edu.uade.sam.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uade.sam.model.PartialResultAnova;
import edu.uade.sam.service.impl.CalculatorServiceAnova;
import edu.uade.sam.service.impl.CalculatorServiceSelector;
import edu.uade.sam.service.impl.CalculatorServiceStudentT;
import edu.uade.sam.utils.csv.CSVParser;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/test-context.xml")
public class CalculatorServiceTest {

	@Autowired
	CSVParser csvParser;

	@Autowired
	static CalculatorService calculatorService;

	static Map<String, double[]> twoGroups;
	static Map<String, double[]> threeGroups;

	@BeforeClass
	public static void init() {
		CalculatorServiceSelector calculator = new CalculatorServiceSelector();
		calculator.setAnova(new CalculatorServiceAnova());
		calculator.setStudentT(new CalculatorServiceStudentT());
		calculatorService = calculator;
		
		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		threeGroups = new HashMap<>();
		threeGroups.put("economics", a);
		threeGroups.put("medicine", b);
		threeGroups.put("history", c);
		
		double[] e = { 26, 25, 43, 34, 18, 52};
		double[] f = { 23, 30, 18, 25, 28};

		twoGroups = new HashMap<>();
		twoGroups.put("female", e);
		twoGroups.put("male", f);
	}

	@Test(expected = RuntimeException.class)
	public void calculate_twogroups_error() {
		calculatorService.calculate(twoGroups, 0.05f);
		Assert.fail();
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

//	@Test
//	public void calculate_fCritValue_ok() {
//
//		ResultAnova r = calculatorService.calculate(threeGroups, 0.05f);
//		Assert.assertEquals("anova fCritvalue", 3.443357, r.getfCritValue(), 0.00001);
//	}

	@Test
	public void calculate_testValue_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);
		Assert.assertEquals("anova test value", true, r.areDifferent());
	}

	@Test
	public void calculate_resultSummary_ok() {
		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertNotNull("anova result summaries", r.getSummaries());
		Assert.assertEquals("anova result summaries", 3, r.getSummaries().size());
	}

	@Test
	public void calculate_resultSummaryName_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary count", "economics", r.getSummaries().get(0).getName());
		Assert.assertEquals("anova result summary count", "medicine", r.getSummaries().get(1).getName());
		Assert.assertEquals("anova result summary count", "history", r.getSummaries().get(2).getName());
	}

	@Test
	public void calculate_resultSummaryCount_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary count", 9, r.getSummaries().get(0).getCount());
		Assert.assertEquals("anova result summary count", 7, r.getSummaries().get(1).getCount(), 0.00001);
		Assert.assertEquals("anova result summary count", 9, r.getSummaries().get(2).getCount(), 0.00001);
	}

	@Test
	public void calculate_resultSummarySum_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary sum", 435, r.getSummaries().get(0).getSum(), 0.00001);
		Assert.assertEquals("anova result summary sum", 420, r.getSummaries().get(1).getSum(), 0.00001);
		Assert.assertEquals("anova result summary sum", 393, r.getSummaries().get(2).getSum(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryMax_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary sum", 54, r.getSummaries().get(0).getMax(), 0.00001);
		Assert.assertEquals("anova result summary sum", 69, r.getSummaries().get(1).getMax(), 0.00001);
		Assert.assertEquals("anova result summary sum", 55, r.getSummaries().get(2).getMax(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryMin_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary sum", 42, r.getSummaries().get(0).getMin(), 0.00001);
		Assert.assertEquals("anova result summary sum", 54, r.getSummaries().get(1).getMin(), 0.00001);
		Assert.assertEquals("anova result summary sum", 35, r.getSummaries().get(2).getMin(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryAverage_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary average", 48.33333, r.getSummaries().get(0).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary average", 60, r.getSummaries().get(1).getAverage(), 0.00001);
		Assert.assertEquals("anova result summary average", 43.66667, r.getSummaries().get(2).getAverage(), 0.00001);
	}

	@Test
	public void calculate_resultSummaryVariance_ok() {

		PartialResultAnova r = (PartialResultAnova) calculatorService.calculate(threeGroups, 0.05f);

		Assert.assertEquals("anova result summary variance", 23.5, r.getSummaries().get(0).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary variance", 32.33333, r.getSummaries().get(1).getVariance(), 0.00001);
		Assert.assertEquals("anova result summary variance", 50.5, r.getSummaries().get(2).getVariance(), 0.00001);
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
