package edu.uade.sam.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import edu.uade.sam.model.Label;
import edu.uade.sam.model.Design;
import edu.uade.sam.model.TestDesignSlot;
import edu.uade.sam.service.DesignService;
import edu.uade.sam.service.LabelService;

@Component
public class DesignServiceImpl implements DesignService {
	
	@Inject
	private LabelService labelService;
	

	public Design createTestDesign(String testName, Integer judges, List<String> samples) {
		//FIXME este id apesta
		Integer id= (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		Design td = new Design();
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(id , samples);
			long seed = System.nanoTime();
			Collections.shuffle(labels, new Random(seed));
			
			td.getTestSlots().add(new TestDesignSlot(i, labels));
		}
		
		return td;
	}

	@Override
	public Design createTestDesignRandom(String testName, Integer judges, List<String> samples) {
		Design design = this.createTestDesign(testName, judges, samples);
		
		for(TestDesignSlot slot : design.getTestSlots()) {
			long seed = System.nanoTime();
			Collections.shuffle(slot.getLabels(), new Random(seed));
		}
		
		return design;
	}
	
	@Override
	public Design getTestDesign(Integer testId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@VisibleForTesting
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}

}