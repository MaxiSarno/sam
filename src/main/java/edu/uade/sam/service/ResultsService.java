package edu.uade.sam.service;

import edu.uade.sam.model.Result;

public interface ResultsService {
	
	Result generate(Integer testId);
	
	Result get(Integer testId);

}
