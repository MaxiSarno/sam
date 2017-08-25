package edu.uade.sam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uade.sam.dao.SensoryEvaluationRepository;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.model.SensoryEvaluationType;
import edu.uade.sam.service.SensoryEvaluationService;

@Component
public class SensoryEvaluationServiceImpl implements SensoryEvaluationService {
	
	@Autowired
	private SensoryEvaluationRepository dao;

	@Override
	public Long save(String name, SensoryEvaluationType type) {
		SensoryEvaluation e = new SensoryEvaluation();
		e.setName(name);
		e.setType(type);
		
		return dao.save(e).getSamId();
	}

	@Override
	public List<SensoryEvaluation> getAll() {
		return dao.findAll();
	}

	@Override
	public SensoryEvaluation get(Long id) {		
		return dao.findOne(id);
	}

}
