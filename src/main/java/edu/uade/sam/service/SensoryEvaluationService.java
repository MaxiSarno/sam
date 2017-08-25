package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.model.SensoryEvaluationType;

/**
 * Evaluaciones realizadas por los jueces en base a las muesrtas recibidas.
 * 
 * @author maxi
 *
 */
@Service
public interface SensoryEvaluationService {

	/**
	 * Crea una nueva evaluacion sensorial.
	 * 
	 * @param name
	 * @param type 
	 * @return testId
	 */
	public Long save(String name, SensoryEvaluationType type);

	/**
	 * Devuelve todas las evaluaciones.
	 * 
	 * @return Lista de Evaluaciones
	 */
	public List<SensoryEvaluation> getAll();

	/**
	 * Devuelve una evaluacion especifica.
	 * 
	 * @param id
	 * @return Evaluacion con ese id
	 */
	public SensoryEvaluation get(Long id);

}
