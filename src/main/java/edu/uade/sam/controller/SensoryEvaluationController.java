package edu.uade.sam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.messaging.SamNotification;
import edu.uade.sam.messaging.SamNotificationCatalog;
import edu.uade.sam.messaging.SamResponse;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.model.SensoryEvaluationScale;
import edu.uade.sam.model.SensoryEvaluationType;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.DesignService;
import edu.uade.sam.service.ResultsService;
import edu.uade.sam.service.SensoryEvaluationService;

@RestController
@RequestMapping("/evaluation")
public class SensoryEvaluationController {

	@Autowired
	private SensoryEvaluationService evaluationService;
	@Autowired
	private DesignService designService;
	@Autowired
	private AttributesService attributesService;
	@Autowired
	private ResultsService resultsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SamResponse> save(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "scale", required = true) String scale) {

		SensoryEvaluationType samType = SensoryEvaluationType.fromString(type);
		SensoryEvaluationScale samScale = SensoryEvaluationScale.fromString(scale);
		
		SamNotification notification = this.validateSensoryEvaluationCreation(name, samType, samScale);

		if (notification != null) {
			return ResponseEntity.badRequest().body(new SamResponse(null, notification));
		}

		Long samId = evaluationService.save(name, samType, samScale, "Maxi Sarno");
		return ResponseEntity.ok().body(SamResponse.data(samId));
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<SensoryEvaluation> getAll() {
		return evaluationService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SensoryEvaluation get(@PathVariable(value = "id") Long id) {
		return evaluationService.get(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCascade(@PathVariable(value = "id") Long id) {
		this.evaluationService.delete(id);
		this.designService.delete(id);
		this.attributesService.deleteBySamId(id);
		this.resultsService.delete(id);
	}

	// TODO sacar a una clase
	private SamNotification validateSensoryEvaluationCreation(String name, SensoryEvaluationType samType,
			SensoryEvaluationScale samScale) {
		
		if (samType == null) {
			return SamNotification.fromCatalog(SamNotificationCatalog.INVALID_SENSORY_EVALUATION_TYPE);
		}
		if (samScale == null) {
			return SamNotification.fromCatalog(SamNotificationCatalog.INVALID_SENSORY_EVALUATION_SCALE);
		}
		
		return null;
	}

}
