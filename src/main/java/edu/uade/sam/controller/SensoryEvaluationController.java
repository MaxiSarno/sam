package edu.uade.sam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.model.SensoryEvaluationType;
import edu.uade.sam.service.SensoryEvaluationService;

@RestController
@RequestMapping("/evaluation")
public class SensoryEvaluationController {
	
	@Inject
	private SensoryEvaluationService evaluationService;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> save(@RequestParam(value="name", required=true) String name, 
			@RequestParam(value="type", required=true)String type) {
		
		SensoryEvaluationType samType = SensoryEvaluationType.fromString(type);
		
		if (samType==null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().body(evaluationService.save(name, samType));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<SensoryEvaluation> getAll() {
		return evaluationService.getAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public SensoryEvaluation get(@PathVariable(value="id") Long id) {
		return evaluationService.get(id);
	}

}
