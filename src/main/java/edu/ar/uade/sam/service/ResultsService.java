package edu.ar.uade.sam.service;

import edu.ar.uade.sam.model.TestResult;

public interface ResultsService {
	
	public void calculateResults(int testId);
	
	public TestResult getResult(int testId);

}
