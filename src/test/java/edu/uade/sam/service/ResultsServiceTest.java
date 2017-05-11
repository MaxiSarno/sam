package edu.uade.sam.service;

import org.junit.Assert;
import org.junit.Test;

import edu.uade.sam.model.EvaluationResult;
import edu.uade.sam.service.impl.ResultsServiceImpl;

public class ResultsServiceTest {

	private ResultsService resultsService = new ResultsServiceImpl(); 
	
	@Test
	public void generate_nivelDeAgrado_ok() {
		EvaluationResult result = resultsService.generate(1);
		Assert.assertNotNull(result);
	}

}
