package edu.uade.sam.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import edu.uade.sam.model.Label;
import edu.uade.sam.model.Design;
import edu.uade.sam.model.DesignSlot;
import edu.uade.sam.service.DesignService;
import edu.uade.sam.service.LabelService;

@Component
public class DesignServiceImpl implements DesignService {
	
	@Inject
	private LabelService labelService;
	
	private Map<Integer, Design> designDAO = new HashMap<>();
	

	public Design generateDesign(String testName, Integer judges, List<String> samples) {
		//FIXME este id apesta
		Integer id= (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		Design td = new Design();
		designDAO.put(id, td);
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(id , samples);
			long seed = System.nanoTime();
			Collections.shuffle(labels, new Random(seed));
			
			td.getDesignSlots().add(new DesignSlot(i, labels));
		}
		
		return td;
	}

	@Override
	public Design generateDesignRandom(String testName, Integer judges, List<String> samples) {
		Design design = this.generateDesign(testName, judges, samples);
		
		for(DesignSlot slot : design.getDesignSlots()) {
			long seed = System.nanoTime();
			Collections.shuffle(slot.getLabels(), new Random(seed));
		}
		
		return design;
	}
	
	@Override
	public Design getTestDesign(Integer testId) {
		return designDAO.get(testId);
	}
	

	@VisibleForTesting
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}

}
