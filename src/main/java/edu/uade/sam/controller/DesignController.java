package edu.uade.sam.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.service.DesignService;

@RestController
@RequestMapping("/design")
public class DesignController {
	
	@Inject
	private DesignService designService;
	
//	@GET
//	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getDesign(@PathVariable(value="id") String id) {
		return "design for "+id;
	}

}
