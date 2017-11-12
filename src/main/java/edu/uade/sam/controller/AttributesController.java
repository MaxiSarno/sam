package edu.uade.sam.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.StringUtils;

import edu.uade.sam.model.Design;
import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.DesignService;
import edu.uade.sam.service.SensoryEvaluationService;
import edu.uade.sam.utils.csv.CSVParser;

@RestController
@RequestMapping("/evaluation/{id}/attributes")
public class AttributesController {

	private static final String TEMPLATE_NAME = "atributos-sam-";

	@Inject
	private AttributesService attributesService;
	
	@Inject
	private DesignService designService;

	@Inject
	private SensoryEvaluationService samService;

	@Inject
	private CSVParser csvParser;

	/**
	 * Help Me Stack Overflow, you're my only hope
	 * http://stackoverflow.com/questions/28277182/how-to-upload-csv-file-to-the-database-using-spring-hibernate-mvc
	 * 
	 * @param id
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> processUpload(@PathVariable(value = "id") long id, @RequestParam MultipartFile file) {

		SensoryEvaluation sam = samService.get(id);
		
		if (sam  == null) {
			return ResponseEntity.badRequest().body("evaluacion sensorial inexistente");
		}
		attributesService.deleteBySamId(id);

		List<NumericAttribute> attributes;
		try {
			attributes = csvParser.parseNumeric(id, sam.getType(), sam.getScale(), file);
			attributesService.save(attributes);
			return ResponseEntity.ok().body("OK");
			
		} catch (Exception e) {
			e.printStackTrace();			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NumericAttribute>> getAttributes(@PathVariable(value = "id") long id) {
		List<NumericAttribute> attributes = attributesService.get(id);

		if (attributes == null || attributes.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok().body(attributes);
	}

	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public void getTemplate(@PathVariable(value = "id", required = true) long id,
			@RequestParam(value = "attributes", required = false) String attributes, HttpServletResponse response)
			throws IOException {

		SensoryEvaluation sam = this.samService.get(id);
		Design design = this.designService.getDesign(id);

		if (sam == null || design == null) {
			return;
		}

		List<String> productList = StringUtils.split(design.getSamples(), ",", true);
		List<String> attributeList = StringUtils.split(attributes, ",", true);

		String csv = this.attributesService.getTemplate(sam.getType(), design.getJudges(), productList, attributeList);

		response.setContentLength((int) csv.length());
		response.setContentType("application/octet-stream");
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + TEMPLATE_NAME + sam.getSamId() + ".csv");
		response.getWriter().print(csv);
	}

}
