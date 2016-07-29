package edu.ar.uade.sam.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

@Controller
@Path("keep-alive")
public class FrontController {

	@GET
	@Produces("text/plain")
	@Consumes("text/plain")
	public String keepAlive() {
		return "i'm still alive";
	}
}
