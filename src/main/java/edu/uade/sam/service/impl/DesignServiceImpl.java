package edu.uade.sam.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import edu.uade.sam.model.Design;
import edu.uade.sam.model.DesignSlot;
import edu.uade.sam.model.Label;
import edu.uade.sam.service.DesignService;
import edu.uade.sam.service.LabelService;
import edu.uade.sam.service.SensoryEvaluationService;

/**
 * @author msarno
 *
 */
@Component
public class DesignServiceImpl implements DesignService {
	
	@Inject
	private LabelService labelService;

	@Autowired
	private SensoryEvaluationService sensoryEvaluationService;
	
	private Map<Integer, Design> designDAO = new HashMap<>();
	

	public Design generateDesign(Integer testId, Integer judges, List<String> samples) {
		if (null == this.sensoryEvaluationService.get(testId)) {
			return null;
		}
		
		Design d = new Design();
		designDAO.put(testId, d);
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(testId , samples);
			d.getDesignSlots().add(new DesignSlot(i, labels));
		}
		
		return d;
	}

	@Override
	public Design generateDesignRandom(Integer testId, Integer judges, List<String> samples) {
		Design design = this.generateDesign(testId, judges, samples);
		
		for(DesignSlot slot : design.getDesignSlots()) {
			Collections.shuffle(slot.getLabels(), new Random(System.nanoTime()));
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

	public void setSensoryEvaluationService(SensoryEvaluationService sensoryEvaluationService) {
		this.sensoryEvaluationService = sensoryEvaluationService;
	}

}
