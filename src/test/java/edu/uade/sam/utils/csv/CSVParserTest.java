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
		List<? extends Attribute> a = this.parser.parseNumeric(mockFile());

		Assert.assertEquals("Checkeo el valor del atributo", 35 * 8, a.get(0).);
	}

	private MultipartFile mockFile() throws FileNotFoundException, IOException {
		File f = new File("src/test/resources/hedonic-attributes-sample.csv");
		InputStream in = new FileInputStream(f);
		MultipartFile file = new MockMultipartFile("tuvieja", in);
		return file;
	}

}
