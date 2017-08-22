package edu.uade.sam.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.model.Result;
import edu.uade.sam.service.ResultsService;

@RestController
@RequestMapping("/evaluation/{id}/results")
public class ResultsController {

	@Inject
	private ResultsService resultsService;
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Result> generate(@PathVariable(value = "id") long id,
			@RequestParam(name = "alpha", required = true) float alpha) {
		
		Result result = resultsService.generate(id, alpha);
		
		if (result == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().body(result);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Result> get(@PathVariable(value = "id") long id) {
		Result result = this.resultsService.get(id);
		
		if (result == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().body(result);
	}

}
