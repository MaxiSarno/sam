package edu.uade.sam.service;

import edu.uade.sam.model.EvaluationResult;

public interface ResultsService {
	
	EvaluationResult generate(Integer testId);
	
	EvaluationResult get(Integer testId);

}
