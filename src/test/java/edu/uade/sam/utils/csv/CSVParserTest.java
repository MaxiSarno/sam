package edu.uade.sam.utils.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.Attribute;
import edu.uade.sam.model.NumericAttribute;

public class CSVParserTest {

	CSVParser parser = new CSVParserImpl();

	@Test
	public void parse_all35x8attributes_ok() throws IOException {
		List<NumericAttribute> a = this.parser.parseNumeric(mockFile());

		Assert.assertEquals("Obtengo todos los atributos", 35 * 8, a.size());
	}
	
	@Test
	public void parse_checkValues_ok() throws IOException {
		List<NumericAttribute> a = this.parser.parseNumeric(mockFile());
		Integer[] values = {6,5,6,5,3,3,3,3,6,4,4,4,3,4,3,3};
		// Panelista 1,6,5,6,5,3,3,3,3
		// Panelista 2,6,4,4,4,3,4,3,3

		for (int i = 0; i < values.length; i++) {
			Assert.assertEquals("Checkeo el valor del atributo", values[i], a.get(i).getValue());
		}
	}

	private MultipartFile mockFile() throws FileNotFoundException, IOException {
		File f = new File("src/test/resources/hedonic-attributes-sample.csv");
		InputStream in = new FileInputStream(f);
		MultipartFile file = new MockMultipartFile("tuvieja", in);
		return file;
	}

}
