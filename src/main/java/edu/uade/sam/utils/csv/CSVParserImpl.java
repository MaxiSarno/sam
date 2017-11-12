package edu.uade.sam.utils.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.SensoryEvaluationScale;
import edu.uade.sam.model.SensoryEvaluationType;

@Component
public class CSVParserImpl implements CSVParser {

	public static final String SEPARATOR = ",";

	@Override
	public List<NumericAttribute> parseNumeric(long samId, SensoryEvaluationType sensoryEvaluationType, SensoryEvaluationScale samScale, MultipartFile file) throws Exception {

		List<NumericAttribute> attributes = new ArrayList<NumericAttribute>();

		int count = 0;
		String[] headerAttribute = null;
		String[] headerProduct = null;

		for (String line : this.readFileLines(file)) {

			String[] values = line.split(SEPARATOR);

			if (0 == count) {
				headerAttribute = values;
			} else if (1 == count) {
				headerProduct = values;
				this.validateHeaders(headerAttribute, headerProduct);
			} else {
				for (int i = 1; i < headerAttribute.length; i++) {
					int value = Integer.parseInt(values[i]);
					NumericAttribute attribute = new NumericAttribute(samId, headerProduct[i], headerAttribute[i], value);
					
					if (!samScale.contains(value)) {
						throw new NuberOutOfScaleException(samScale, attribute);
					}
					
					attributes.add(attribute);
				}
			}
			count++;
		}

		return attributes;
	}

	private void validateHeaders(String[] headerAttribute, String[] headerProduct) throws AttributesHeaderException {
		if (headerAttribute.length != headerProduct.length) {
			throw new AttributesHeaderException("la cantidad de atributos no coincide con la cantidad de productos");
		}
		
		for (int i = 1; i < headerAttribute.length; i++) {
			if (headerProduct[i].isEmpty() || headerAttribute[i].isEmpty()) {
				throw new AttributesHeaderException("hay algun campo vacio");
			}
		}
	}

	private List<String> readFileLines(MultipartFile file) {
		List<String> lines = new ArrayList<String>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			String line;

			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return lines;
	}

}
