package edu.uade.sam.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.HedonicAttribute;

public class CSVUtils {

	public static String SEPARATOR = ",";
	public static String HEADER_SEPARATOR = "-";

	public List<HedonicAttribute> readCSVHedonicAttribute(MultipartFile file) {
		List<HedonicAttribute> attributes = new ArrayList<HedonicAttribute>();
		
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(
					file.getInputStream()));

			String line;
			boolean isHeader = true;
			String[] header = null;

			while ((line = reader.readLine()) != null) {
				String[] values = line.split(SEPARATOR);
				if (isHeader) {
					header = values;
					this.validateHeader(header);
					isHeader = false;
				} else {
					for(int i=1; i<header.length; i++) {
						String[] head = header[i].split(HEADER_SEPARATOR);
						HedonicAttribute attribute = new HedonicAttribute(head[0], head[1], Integer.parseInt(values[i]));
						attributes.add(attribute);
					}
				}
				
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

		return attributes;
	}

	private void validateHeader(String[] header) {
		// TODO Auto-generated method stub
		
	}

}
