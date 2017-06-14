package edu.uade.sam.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.service.ResultsService;

@RestController
@RequestMapping("/evaluation/{id}/results")
public class ResultsController {
	
	@Inject
	private ResultsService resultsService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(@PathVariable(value="{id}") Integer id) {
		resultsService.get(id);
	}

}
