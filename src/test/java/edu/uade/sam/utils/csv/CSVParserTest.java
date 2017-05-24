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

import edu.uade.sam.model.NumericAttribute;

public class CSVParserTest {

	CSVParser parser = new CSVParserImpl();

	@Test
	public void parse_all35x8attributes_ok() throws IOException {
		List<NumericAttribute> a = this.parser.parseNumeric(this.mockFile());

		Assert.assertEquals("Obtengo todos los atributos del csv", 35 * 8, a.size());
	}
	
	@Test
	public void parse_checkValues_ok() throws IOException {
		List<NumericAttribute> a = this.parser.parseNumeric(mockFile());
		Integer[] values = {6,5,6,5,3,3,3,3,6,4,4,4,3,4,3,3};
		// Panelista 1,6,5,6,5,3,3,3,3
		// Panelista 2,6,4,4,4,3,4,3,3

		for (int i = 0; i < values.length; i++) {
			Assert.assertEquals("Checkeo el valor de los atributos", values[i], a.get(i).getValue());
		}
	}
	
	@Test
	public void parse_checkProduct_ok() throws IOException {
		List<NumericAttribute> a = this.parser.parseNumeric(mockFile());
		// Panelista 1,6,5,6,5,3,3,3,3
		// Panelista 2,6,4,4,4,3,4,3,3

		for (int i = 0; i < a.size(); i=i+2) {
			Assert.assertEquals("Checkeo el producto de los atributos", "prod 1", a.get(i).getProduct());
		}
		
		for (int i = 1; i < a.size(); i=i+2) {
			Assert.assertEquals("Checkeo el producto de los atributos", "prod 2", a.get(i).getProduct());
		}
	}
	
//	@Test
//	public void parse_checkAttribute_ok() throws IOException {
//		List<NumericAttribute> a = this.parser.parseNumeric(mockFile());
//		//agrado del sabor,agrado del sabor,agrado del sabor residual,agrado del sabor residual,intensidad del sabor,intensidad del sabor,intensidad del sabor residual,intensidad del sabor residual
//
//		for (int i = 0; i < a.size(); i++) {			
//			Assert.assertEquals("Checkeo el producto de los atributos", "prod 1", a.get(i).getAttribute());
//		}
//		
//		for (int i = 1; i < a.size(); i=i+2) {
//			Assert.assertEquals("Checkeo el producto de los atributos", "prod 2", a.get(i).getAttribute());
//		}
//	}

	private MultipartFile mockFile() throws FileNotFoundException, IOException {
		File f = new File("src/test/resources/hedonic-attributes-sample.csv");
		InputStream in = new FileInputStream(f);
		MultipartFile file = new MockMultipartFile("tuvieja", in);
		return file;
	}

}
