package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.model.SensoryEvaluationScale;
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
	 * @param scale
	 * @param author
	 * @return
	 */
	public Long save(String name, SensoryEvaluationType type, SensoryEvaluationScale scale, String author);
	

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


	/**
	 * Borra la evaluacion sensorial
	 * 
	 * @param id
	 */
	public void delete(Long id);

}
