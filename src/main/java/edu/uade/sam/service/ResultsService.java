package edu.uade.sam.service;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.Result;

/**
 * Resultados de las evaluaciones sensoriales.
 * 
 * @author msarno
 *
 */
@Service
public interface ResultsService {
	
	/**
	 * Genera el resultado de la evaluación en base a un error α
	 * Nivel de confianza = 1-α
	 * 
	 * @param testId
	 * @param alpha
	 * @return
	 */
	Result generate(long samId, float alpha);
	
	/**
	 * 
	 * @param testId
	 * @return
	 */
	Result get(long samId);

	/**
	 * Borra los resultados
	 * 
	 * @param id
	 */
	void delete(Long id);

}
