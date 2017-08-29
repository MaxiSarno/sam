package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;

import edu.uade.sam.dao.DesignRepository;
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

	@Autowired
	private SensoryEvaluationService sensoryEvaluationService;
	
	@Autowired
	private DesignRepository designDao;
	

	public Design generateDesign(Long testId, Integer judges, List<String> samples, boolean random) {
		if (random) {
			return this.generateDesignRandom(testId, judges, samples);
		}
		return this.generateDesign(testId, judges, samples);
	}
	
	private Design generateDesign(Long testId, Integer judges, List<String> samples) {
		if (null == this.sensoryEvaluationService.get(testId)) {
			return null;
		}
		
		LabelService labelService = new LabelServiceImpl();
		List<DesignSlot> designSlots = new ArrayList<>();
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(samples);
			designSlots.add(new DesignSlot(i, labels));
		}

		Design d = new Design(testId, designSlots);
		
		return designDao.save(d);
	}

	private Design generateDesignRandom(Long testId, Integer judges, List<String> samples) {
		Design design = this.generateDesign(testId, judges, samples);
		
		for(DesignSlot slot : design.getDesignSlots()) {
			Collections.shuffle(slot.getLabels(), new Random(System.nanoTime()));
		}
		
		return design;
	}
	
	@Override
	public Design getTestDesign(Long samId) {
		return designDao.findOne(samId);
	}

	@VisibleForTesting
	public void setSensoryEvaluationService(SensoryEvaluationService sensoryEvaluationService) {
		this.sensoryEvaluationService = sensoryEvaluationService;
	}
	
	@VisibleForTesting
	public void setDesignDao(DesignRepository designDao) {
		this.designDao = designDao;
	}

}
