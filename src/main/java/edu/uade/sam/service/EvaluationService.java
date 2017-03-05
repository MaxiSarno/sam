package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.SAMEvaluation;

/**
 * Evaluaciones realizadas por los jueces en base a las muesrtas recibidas.
 * 
 * @author maxi
 *
 */
@Service
public interface EvaluationService {

	/**
	 * Crea una nueva evaluacion sensorial.
	 * 
	 * @param testName
	 * @return testId
	 */
	public Integer save(String testName);

	/**
	 * Devuelve todas las evaluaciones.
	 * 
	 * @return Lista de Evaluaciones
	 */
	public List<SAMEvaluation> getAll();

	/**
	 * Devuelve una evaluacion especifica.
	 * 
	 * @param id
	 * @return Evaluacion con ese id
	 */
	public SAMEvaluation get(Integer id);

}
