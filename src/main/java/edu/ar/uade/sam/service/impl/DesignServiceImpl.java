package edu.ar.uade.sam.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.google.common.annotations.VisibleForTesting;

import edu.ar.uade.sam.model.Label;
import edu.ar.uade.sam.model.TestDesign;
import edu.ar.uade.sam.service.DesignService;
import edu.ar.uade.sam.service.LabelService;

public class DesignServiceImpl implements DesignService {
	
	@Inject
	private LabelService labelService;

	public TestDesign createTestDesign(Integer testId, int personnel, List<String> samples) {
		List<String> descriptions = Arrays.asList("Tang", "Clight", "BC");
		List<Label> labels = labelService.createLabels(testId , descriptions);
		System.out.println(labels);
		return null;
	}

	@VisibleForTesting
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}

}
