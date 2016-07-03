package edu.ar.uade.sam.service;

import java.util.List;

import edu.ar.uade.sam.model.Label;

public interface LabelService {
	
	public List<Label> createLabels(Integer testId, List<String> descriptions);

}
