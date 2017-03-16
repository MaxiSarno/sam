package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import edu.uade.sam.model.HedonicAttribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.AttributesService;
import edu.uade.sam.service.ResultsService;

@Component
public class ResultsServiceImpl implements ResultsService {
	
	private Map<Integer, Result> resultsDao;

	@Inject
	private AttributesService attributesService;

	@Override
	public Result getResult(int id) {
		if (!resultsDao.containsKey(id)) {
			this.calculateResults(id);
		}
		
		return this.resultsDao.get(id);
	}
	
	@Override
	public void calculateResults(int id) {
		Map<String, List<Integer>> a = this.getAttributesMap(id);
		
		//Aca pasa la magia
	}

	private Map<String, List<Integer>> getAttributesMap(int id) {
		Map<String, List<Integer>> attributesMap = new HashMap<>();
		
		List<HedonicAttribute> attributes = (List<HedonicAttribute>) attributesService.get(id);
				
		for (HedonicAttribute a : attributes) {
			if (!attributesMap.containsKey(a.getAttribute())) {
				attributesMap.put(a.getAttribute(), new ArrayList<>());
			}
			
			attributesMap.get(a.getAttribute()).add(a.getValue());
		}
		
		return attributesMap;
	}

}
