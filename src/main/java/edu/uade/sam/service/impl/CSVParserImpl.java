package edu.uade.sam.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.Attribute;
import edu.uade.sam.model.HedonicAttribute;
import edu.uade.sam.service.CSVParser;

@Component
public class CSVParserImpl implements CSVParser {

	public static final String SEPARATOR = ",";
	public static final String HEADER_SEPARATOR = "-";

	@Override
	public List<? extends Attribute> parse(MultipartFile file) {

		List<HedonicAttribute> attributes = new ArrayList<HedonicAttribute>();

		boolean isHeader = true;
		String[] header = null;

		for (String line : this.readFileLines(file)) {

			String[] values = line.split(SEPARATOR);
			if (isHeader) {
				header = values;
				this.validateHeader(header);
				isHeader = false;
			} else {
				for (int i = 1; i < header.length; i++) {
					String[] head = header[i].split(HEADER_SEPARATOR);
					HedonicAttribute attribute = new HedonicAttribute(head[0],
							head[1], Integer.parseInt(values[i]));
					attributes.add(attribute);
				}
			}
		}
		
		return attributes;
	}

	private void validateHeader(String[] header) {
		//FIXME validar posta
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
