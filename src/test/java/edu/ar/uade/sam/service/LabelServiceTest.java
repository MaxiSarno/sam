package edu.ar.uade.sam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.ar.uade.sam.model.Label;
import edu.ar.uade.sam.service.impl.LabelServiceImpl;

public class LabelServiceTest {
	
	private LabelService labelService = new LabelServiceImpl();
	
	@Test
	public void testCreateLabels() {
		List<String> descriptions = Arrays.asList("Tang", "Clight", "BC");
		Integer testId = 1;
		List<Label> labels = labelService.createLabels(testId , descriptions);
		
		for(Label l : labels) {
			Assert.assertEquals("TestId", testId,l.getTestId());
		}
	}
	
	@Test
	public void testAmountOfLabelsGenerated() {
		List<String> descriptions = Arrays.asList("Tang", "Clight", "BC");
		List<Label> labels = labelService.createLabels(2, descriptions);
		Assert.assertEquals("Same amount of labels as descriptions", descriptions.size(), labels.size());
	}

	@Test
	public void testNoDuplicateNumbers() {
		List<Integer> labelNumbers = new ArrayList<Integer>();
		
		List<String> descriptions = Arrays.asList("Tang", "Clight", "BC");
		int limit = LabelServiceImpl.LABEL_MAX_VALUE/descriptions.size();
		
		for(int i=0; i<limit; i++) {
			List<Label> labels = labelService.createLabels(3, descriptions);
			for (Label l : labels) {
				Assert.assertFalse(labelNumbers.contains(l.getLabelNumber()));
				labelNumbers.add(l.getLabelNumber());
			}
		}
		
	}
	
}
