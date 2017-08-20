package edu.uade.sam.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import edu.uade.sam.dao.AttributeRepository;
import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.service.AttributesService;

@Component
public class AttributesServiceImpl implements AttributesService {

	@Inject
	private AttributeRepository dao;
	
	
	@Override
	public void save(long samId, List<NumericAttribute> attributes) {
		//FIXME sacar el id
		dao.save(attributes);
	}

	@Override
	public List<NumericAttribute> get(long samId) {
		return dao.findBySamId(samId);
	}

}
