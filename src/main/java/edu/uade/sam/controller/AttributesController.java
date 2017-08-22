package edu.uade.sam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.SensoryEvaluationService;
import edu.uade.sam.utils.csv.CSVParser;

@RestController
@RequestMapping("/evaluation/{id}/attributes")
public class AttributesController {
	
	@Inject
	private AttributesService attributesService;
	
	@Inject
	private SensoryEvaluationService samService;
	
	@Inject
	private CSVParser csvParser;
	

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public ResponseEntity<String> processUpload(@PathVariable(value = "id") long id, @RequestParam MultipartFile file) {
		
		if (samService.get(id) == null) {
			return ResponseEntity.badRequest().body("evaluacion sensorial inexistente");
		}
		
		List<NumericAttribute> attributes = csvParser.parseNumeric(id, file);
		attributesService.save(id, attributes);
		// http://stackoverflow.com/questions/28277182/how-to-upload-csv-file-to-the-database-using-spring-hibernate-mvc
		return ResponseEntity.ok().body("OK");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NumericAttribute>> getAttributes(@PathVariable(value = "id") Integer id) {
		List<NumericAttribute> attributes = attributesService.get(id);
		
		if (attributes == null || attributes.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().body(attributes) ;
	}

}
