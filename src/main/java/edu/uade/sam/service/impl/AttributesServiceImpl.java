package edu.uade.sam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.service.AttributesService;

@Component
public class AttributesServiceImpl implements AttributesService {
	
	private Map<Integer, List<NumericAttribute>> dao;
	
	@PostConstruct
	public void init() {
		dao = new HashMap<>();
	}
	
	@Override
	public void save(Integer evaluationId, List<NumericAttribute> attributes) {
		dao.put(evaluationId, attributes);
	}

	@Override
	public List<NumericAttribute> get(Integer evaluationId) {
		return dao.get(evaluationId);
	}

}
