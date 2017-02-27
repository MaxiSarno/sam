package edu.uade.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

import edu.uade.service.EvaluationService;

@Controller
@Path("eval")
public class EvaluationController {
	
	@Inject
	private EvaluationService evaluationService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postEval() {
		return evaluationService.saveEvaluation();
	}

}
