package edu.uade.sam.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.EvaluationResult;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.EvaluationService;
import edu.uade.sam.service.ResultsService;

@Component
public class ResultsServiceImpl implements ResultsService {
	
	private Map<Integer, Result> resultsDao;

	@Autowired
	private EvaluationService evaluationService;

	@Override
	public EvaluationResult generate(Integer testId) {
		//if (null != this.evaluationService.get(testId))
		return null;
	}
	
	@Override
	public EvaluationResult get(Integer testId) {
		// TODO Auto-generated method stub
		return null;
	}

}
