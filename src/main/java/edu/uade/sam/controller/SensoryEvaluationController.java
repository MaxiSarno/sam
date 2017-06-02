package edu.uade.sam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.service.SensoryEvaluationService;

@RestController
@RequestMapping("/evaluation")
public class SensoryEvaluationController {
	
	@Inject
	private SensoryEvaluationService evaluationService;

	@RequestMapping(method=RequestMethod.POST)
	public Integer save(@RequestParam(value="name", required=true) String name) {
		return evaluationService.save(name);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<SensoryEvaluation> getAll() {
		return evaluationService.getAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public SensoryEvaluation get(@PathVariable(value="id") Integer id) {
		return evaluationService.get(id);
	}

}
