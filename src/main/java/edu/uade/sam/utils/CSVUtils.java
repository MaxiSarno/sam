package edu.uade.sam.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.web.multipart.MultipartFile;

public class CSVUtils {
	
	public void readAttributeCSV(MultipartFile file) {
		InputStream input;
		BufferedReader reader = null;
		
		try {
			input = file.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input));
		
			String line;
			while ((line = reader.readLine()) != null) {
			  System.out.println(line);       
			}
			
	        String cvsSplitBy = ",";
	        line.split(cvsSplitBy);
	        
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
	}

}
