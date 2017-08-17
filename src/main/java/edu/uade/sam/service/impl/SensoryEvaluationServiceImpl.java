package edu.uade.sam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uade.sam.dao.SensoryEvaluationRepository;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.service.SensoryEvaluationService;

@Component
public class SensoryEvaluationServiceImpl implements SensoryEvaluationService {
	
	@Autowired
	private SensoryEvaluationRepository dao;
//	private Map<Long, SensoryEvaluation> cache = new HashMap<>();

	@Override
	public Long save(String name) {
		//FIXME este id apesta
		//Long id= (System.currentTimeMillis() % Long.MAX_VALUE);
		SensoryEvaluation evaluation = new SensoryEvaluation();
		evaluation.setName(name);
		//evaluation.setId(id);
		//dao.put(id, evaluation);
		
		return dao.save(evaluation).getTestId();
	}

	@Override
	public List<SensoryEvaluation> getAll() {
		//return cache.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return dao.findAll();
	}

	@Override
	public SensoryEvaluation get(Long id) {		
		//return cache.get(id);
		return dao.findOne(id);
	}

}
