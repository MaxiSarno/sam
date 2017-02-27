package edu.uade.service;

import org.springframework.stereotype.Service;

import edu.uade.model.TestResult;

/**
 * Resultados calculados en base a los datos de cada prueba.
 * 
 * @author maxi
 *
 */
@Service
public interface ResultsService {
	
	public void calculateResults(int testId);
	
	public TestResult getResult(int testId);

}
