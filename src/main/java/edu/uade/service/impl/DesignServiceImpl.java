package edu.ar.uade.sam.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.google.common.annotations.VisibleForTesting;

import edu.ar.uade.sam.model.Label;
import edu.ar.uade.sam.model.TestDesign;
import edu.ar.uade.sam.model.TestDesignSlot;
import edu.ar.uade.sam.service.DesignService;
import edu.ar.uade.sam.service.LabelService;

public class DesignServiceImpl implements DesignService {
	
	@Inject
	private LabelService labelService;

	public TestDesign createTestDesign(Integer testId, int judges, List<String> samples) {
		TestDesign td = new TestDesign(testId);
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(testId , samples);
			long seed = System.nanoTime();
			Collections.shuffle(labels, new Random(seed));
			
			td.getTestSlots().add(new TestDesignSlot(i, labels));
		}
		
		return td;
	}

	@VisibleForTesting
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}

	@Override
	public String alala() {
		return "alala";
	}

	@Override
	public TestDesign createTestDesignRandom(Integer testId, int judges, List<String> samples) {
		TestDesign design = this.createTestDesign(testId, judges, samples);
		
		for(TestDesignSlot slot : design.getTestSlots()) {
			long seed = System.nanoTime();
			Collections.shuffle(slot.getLabels(), new Random(seed));
		}
		
		return design;
	}

}
