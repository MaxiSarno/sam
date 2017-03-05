package edu.uade.sam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.HedonicAttribute;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.utils.CSVUtils;

@RestController
@RequestMapping("/attributes")
public class AttributesController {
	
	@Inject
	private AttributesService attributesService;

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public void processUpload(@RequestParam MultipartFile file) {
		CSVUtils util = new CSVUtils();
		List<HedonicAttribute> attributes = util.readCSVHedonicAttribute(file);
		attributesService.save(0, attributes);
		
		for (HedonicAttribute a : attributes) {
			System.out.println(a);
		}
		
		// http://stackoverflow.com/questions/28277182/how-to-upload-csv-file-to-the-database-using-spring-hibernate-mvc
	}

}
