package edu.ar.uade.sam.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

import edu.ar.uade.sam.service.DesignService;

@Controller
@Path("design")
public class DesignController {
	
	@Inject 
	private DesignService designService;
	
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String getDesign() {
		return this.designService.alala();
	}

}
