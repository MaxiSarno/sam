package edu.uade.sam.utils.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.Attribute;
import edu.uade.sam.model.NumericAttribute;

@Component
public class CSVParserImpl implements CSVParser {

	public static final String SEPARATOR = ",";

	@Override
	public List<NumericAttribute> parseNumeric(MultipartFile file) {

		List<NumericAttribute> attributes = new ArrayList<NumericAttribute>();

		int count = 0;
		String[] headerAttribute = null;
		String[] headerSample = null;

		for (String line : this.readFileLines(file)) {

			String[] values = line.split(SEPARATOR);
			
			if (0 == count) {
				headerAttribute = values;
				// FIXME this.validateHeader(header);
			} else if (1 == count) {
				headerSample = values;
				// FIXME this.validateHeader(header);
			}else {
				for (int i = 1; i < headerAttribute.length; i++) {
					NumericAttribute attribute = new NumericAttribute(headerAttribute[i],
							headerSample[i], Integer.parseInt(values[i]));
					attributes.add(attribute);
				}
			}
			count++;
		}
		
		return attributes;
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
