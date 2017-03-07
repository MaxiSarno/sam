package edu.uade.sam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.uade.sam.model.SAMEvaluation;
import edu.uade.sam.service.EvaluationService;

@Component
public class EvaluationServiceImpl implements EvaluationService {
	
	private Map<Integer, SAMEvaluation> dao;

	@Override
	public Integer save(String testName) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public List<SAMEvaluation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAMEvaluation get(Integer id) {
		if (!dao.containsKey(id)) {
			this.generate(id);
		}
		
		return dao.get(id);
	}

	@Override
	public SAMEvaluation generate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
