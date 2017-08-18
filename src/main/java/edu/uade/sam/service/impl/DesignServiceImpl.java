package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

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
	
	@Inject
	private LabelService labelService;

	@Autowired
	private SensoryEvaluationService sensoryEvaluationService;
	
	@Autowired
	private DesignRepository designDao;
	

	public Design generateDesign(Long testId, Integer judges, List<String> samples) {
		if (null == this.sensoryEvaluationService.get(testId)) {
			return null;
		}
		
		List<DesignSlot> designSlots = new ArrayList<>();
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(testId , samples);
			designSlots.add(new DesignSlot(i, labels));
		}

		Design d = new Design(testId, designSlots);
		
		return designDao.save(d);
	}

	@Override
	public Design generateDesignRandom(Long testId, Integer judges, List<String> samples) {
		Design design = this.generateDesign(testId, judges, samples);
		
		for(DesignSlot slot : design.getDesignSlots()) {
			Collections.shuffle(slot.getLabels(), new Random(System.nanoTime()));
		}
		
		return design;
	}
	
	@Override
	public Design getTestDesign(Long testId) {
		return designDao.findBySensoryEvaluationId(testId);
	}

	
	@VisibleForTesting
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
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
