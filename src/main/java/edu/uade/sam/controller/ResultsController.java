package edu.uade.sam.controller;

import javax.inject.Inject;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public Result generate(@PathVariable(value="id") Integer id, @RequestParam(name="alpha", required=true) float alpha) {
		return resultsService.generate(id, alpha);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Result get(@PathVariable(value="	id") Integer id) {
		return resultsService.get(id);
	}

}
