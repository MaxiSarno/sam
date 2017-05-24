package edu.uade.sam.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.impl.CalculatorServiceImpl;
import edu.uade.sam.utils.csv.CSVParser;

public class CalculatorServiceTest {

	@Autowired
	CSVParser csvParser;

	CalculatorService calculatorService = new CalculatorServiceImpl();

	// @Test
	public void calculate_tStudent_ok() throws FileNotFoundException,
			IOException {
		List<NumericAttribute> attributes = this.csvParser.parseNumeric(this
				.mockFile());
	}

	@Test
	public void calculate_anovaPValue_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		Result r = calculatorService.performAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova p-value", 7.16E-5, r.getpValue(), 0.00001);
	}

	@Test
	public void calculate_anovaFValue_ok() {

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

		Result r = calculatorService.performAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova Fvalue", 15.19623, r.getfValue(), 0.00001);
	}

	@Test
	public void calculate_anovaFCritValue_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		Result r = calculatorService.performAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova fCritvalue", 3.443357, r.getfCritValue(),
				0.00001);
	}

	@Test
	public void calculate_anovaTestValue_ok() {

		double[] a = { 42, 53, 49, 53, 43, 44, 45, 52, 54 };
		double[] b = { 69, 54, 58, 64, 64, 55, 56 };
		double[] c = { 35, 40, 53, 42, 50, 39, 55, 39, 40 };

		Result r = calculatorService.performAnova(Arrays.asList(a, b, c));

		Assert.assertEquals("anova test value", true, r.isTestValue());
	}

	private List<NumericAttribute> mockAttributes(String product,
			List<Integer> values) {
		String attribute = "attribute";

		return values.stream()
				.map(v -> (new NumericAttribute(product, attribute, v)))
				.collect(Collectors.toList());
	}

	private MultipartFile mockFile() throws FileNotFoundException, IOException {
		File f = new File("src/test/resources/hedonic-attributes-sample.csv");
		InputStream in = new FileInputStream(f);
		MultipartFile file = new MockMultipartFile("tuvieja", in);
		return file;
	}

}
