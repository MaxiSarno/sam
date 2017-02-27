package edu.uade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.model.Label;

/**
 * Etiquetas para las muestras de cada experimento.
 * 
 * @author maxi
 *
 */
@Service
public interface LabelService {
	
	/**
	 * Create n labels associated to n descriptions for a specific test.  
	 * 
	 * @param testId
	 * @param descriptions
	 * @return
	 */
	public List<Label> createLabels(Integer testId, List<String> descriptions);

}
