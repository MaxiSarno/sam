package edu.uade.sam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uade.sam.dao.SensoryEvaluationRepository;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.model.SensoryEvaluationScale;
import edu.uade.sam.model.SensoryEvaluationType;
import edu.uade.sam.service.SensoryEvaluationService;

@Component
public class SensoryEvaluationServiceImpl implements SensoryEvaluationService {
	
	@Autowired
	private SensoryEvaluationRepository dao;

	@Override
	public Long save(String name, SensoryEvaluationType type, SensoryEvaluationScale scale, String author) {
		SensoryEvaluation e = new SensoryEvaluation(name, type, scale, author);
		
		return this.dao.save(e).getSamId();
	}

	@Override
	public List<SensoryEvaluation> getAll() {
		return this.dao.findAll();
	}

	@Override
	public SensoryEvaluation get(Long id) {		
		return this.dao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

}
