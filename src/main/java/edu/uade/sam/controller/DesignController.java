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
@RequestMapping("/evaluation/{id}/design")
public class DesignController {
	
	@Inject
	private DesignService designService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public Design getDesign(@PathVariable(value="id") Integer id) {
		return designService.getTestDesign(id);
	}
	
	//TODO algun metodo que devuelva el csv?
	
	@RequestMapping(method=RequestMethod.POST)
	public Design createDesign(@PathVariable(value="id") Integer id, @RequestParam(value="judges", required=true) Integer judges, @RequestParam(value="samples", required=true) String samples) {
		return this.designService.generateDesign(id, judges, Arrays.asList(samples.split(",")));
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteDesign(@PathVariable(value="id") Integer id) {
		return "delete design not implemented";
	}

}
