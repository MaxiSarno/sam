package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.service.SensoryEvaluationService;

@Component
public class SensoryEvaluationServiceImpl implements SensoryEvaluationService {
	
	private Map<Integer, SensoryEvaluation> dao = new HashMap<>();

	@Override
	public Integer save(String name) {
		//FIXME este id apesta
		Integer id= (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		SensoryEvaluation evaluation = new SensoryEvaluation();
		evaluation.setName(name);
		evaluation.setId(id);
		
		dao.put(id, evaluation);
		
		return id;
	}

	@Override
	public List<SensoryEvaluation> getAll() {
		return dao.values().stream().collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public SensoryEvaluation get(Integer id) {		
		return dao.get(id);
	}

}