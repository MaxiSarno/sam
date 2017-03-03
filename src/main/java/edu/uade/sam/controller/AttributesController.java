package edu.uade.sam.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.utils.CSVUtils;

@RestController
@RequestMapping("/attributes")
public class AttributesController {

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public void processUpload(@RequestParam MultipartFile file)
			throws IOException {
		CSVUtils util = new CSVUtils();
		util.readAttributeCSV(file);
		System.out.println("yada yada yada");
		
		// http://stackoverflow.com/questions/28277182/how-to-upload-csv-file-to-the-database-using-spring-hibernate-mvc
	}

}
