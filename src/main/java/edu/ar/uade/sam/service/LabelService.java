package edu.ar.uade.sam.service;

import java.util.List;

import edu.ar.uade.sam.model.Label;

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
