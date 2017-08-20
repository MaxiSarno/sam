package edu.uade.sam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.utils.csv.CSVParser;

@RestController
@RequestMapping("/evaluation/{id}/attributes")
public class AttributesController {
	
	@Inject
	private AttributesService attributesService;
	
	@Inject
	private CSVParser csvParser;

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public void processUpload(@PathVariable(value = "id") long samId, @RequestParam MultipartFile file) {
		List<NumericAttribute> attributes = csvParser.parseNumeric(samId, file);
		attributesService.save(samId, attributes);
		// http://stackoverflow.com/questions/28277182/how-to-upload-csv-file-to-the-database-using-spring-hibernate-mvc
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<NumericAttribute> getAttributes(@PathVariable(value = "id") Integer id) {
		return attributesService.get(id);
	}

}
