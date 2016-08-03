package edu.ar.uade.sam.service;

import edu.ar.uade.sam.model.TestResult;

/**
 * Resultados calculados en base a los datos de cada prueba.
 * 
 * @author maxi
 *
 */
public interface ResultsService {
	
	public void calculateResults(int testId);
	
	public TestResult getResult(int testId);

}
