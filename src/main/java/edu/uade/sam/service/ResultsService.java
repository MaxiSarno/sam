package edu.uade.sam.service;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.Result;

/**
 * Resultados calculados en base a los datos de cada prueba.
 * 
 * @author maxi
 *
 */
@Service
public interface ResultsService {
	
	public Result getResult(int id);
	
	public void calculateResults(int id);

}
