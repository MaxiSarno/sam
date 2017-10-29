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
	private DesignRepository dao;
	

	public Design generateDesign(Long samId, Integer judges, List<String> samples, boolean random) {
		Design d = this.generateDesign(samId, judges, samples);
		
		if (random) {
			for (DesignSlot slot : d.getDesignSlots()) {
				Collections.shuffle(slot.getLabels(), new Random(System.nanoTime()));
			}
		}
		
		return this.dao.save(d);
	}
	
	private Design generateDesign(Long samId, Integer judges, List<String> samples) {
		if (null == this.sensoryEvaluationService.get(samId)) {
			return null;
		}
		
		LabelService labelService = new LabelServiceImpl();
		List<DesignSlot> designSlots = new ArrayList<>();
		
		for (int i=1; i<=judges; i++) {
			List<Label> labels = labelService.createLabels(samples);
			designSlots.add(new DesignSlot(i, labels));
		}

		return new Design(samId, judges, String.join(",", samples), designSlots);
	}
	
	@Override
	public Design getDesign(Long samId) {
		return this.dao.findOne(samId);
	}

	@VisibleForTesting
	public void setSensoryEvaluationService(SensoryEvaluationService sensoryEvaluationService) {
		this.sensoryEvaluationService = sensoryEvaluationService;
	}
	
	@VisibleForTesting
	public void setDesignDao(DesignRepository designDao) {
		this.dao = designDao;
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

}
