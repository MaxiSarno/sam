package edu.uade.sam.service;

import edu.uade.sam.model.Result;

public interface ResultsService {
	
	Result generate(Integer testId, float alpha);
	
	Result get(Integer testId);

}
