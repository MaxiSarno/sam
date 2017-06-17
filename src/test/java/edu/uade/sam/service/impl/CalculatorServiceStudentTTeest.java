package edu.uade.sam.service.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uade.sam.service.CalculatorService;

/**
 * @author msarno
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceStudentTTeest {

	@Autowired
	@Qualifier("CalculatorServiceStudentT")
	private CalculatorService calculatorService;

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
