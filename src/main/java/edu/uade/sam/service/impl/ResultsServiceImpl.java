package edu.uade.sam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uade.sam.model.Attribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.ResultsService;
import edu.uade.sam.service.SensoryEvaluationService;

@Component
public class ResultsServiceImpl implements ResultsService {
	
	private Map<Integer, Result> resultsDao;

	@Autowired
	private SensoryEvaluationService evaluationService;
	
	@Autowired
	private AttributesService attributesService;
	

	@Override
	public Result generate(Integer testId) {
		//if (null != this.evaluationService.get(testId))
		List<? extends Attribute> attributes = attributesService.get(testId);
		
		return null;
	}
	
	@Override
	public Result get(Integer testId) {
		if (!resultsDao.containsKey(testId)) {
			this.generate(testId);
		}
		
		return resultsDao.get(testId);
	}

}
