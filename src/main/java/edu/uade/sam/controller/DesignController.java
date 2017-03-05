package edu.uade.sam.controller;

import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.model.Design;
import edu.uade.sam.service.DesignService;

@RestController
@RequestMapping("/design")
public class DesignController {
	
	@Inject
	private DesignService designService;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Design getDesign(@PathVariable(value="id") Integer id) {
		return designService.getTestDesign(id);
	}
	
	//TODO algun metodo que devuelva el csv?
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public Design createDesign(@PathVariable(value="id") String id, @RequestParam(value="judges", required=true) Integer judges, @RequestParam(value="samples", required=true) String samples) {
		return this.designService.generateDesign(id, judges, Arrays.asList(samples.split(",")));
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String deleteDesign(@PathVariable(value="id") String id) {
		return "delete design not implemented";
	}

}
