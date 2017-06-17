package edu.uade.sam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uade.sam.model.Label;
import edu.uade.sam.service.LabelService;
import edu.uade.sam.service.impl.LabelServiceImpl;


/**
 * @author msarno
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelServiceTest {

	@Autowired
	private LabelService labelService;

	private static final List<String> descriptions = Arrays.asList("Tang", "Clight", "BC");

	@Test
	public void testCreateLabels() {
		Integer testId = 1;
		List<Label> labels = labelService.createLabels(testId, LabelServiceTest.descriptions);

		for (Label l : labels) {
			Assert.assertEquals("TestId", testId, l.getTestId());
		}
	}

	@Test
	public void testAmountOfLabelsGenerated() {
		List<Label> labels = labelService.createLabels(2, LabelServiceTest.descriptions);
		Assert.assertEquals("Same amount of labels as descriptions", LabelServiceTest.descriptions.size(),
				labels.size());
	}

	@Test
	public void testNoDuplicateNumbers() {
		List<Integer> labelNumbers = new ArrayList<Integer>();

		int limit = LabelServiceImpl.LABEL_MAX_VALUE / LabelServiceTest.descriptions.size();

		for (int i = 0; i < limit; i++) {
			List<Label> labels = labelService.createLabels(3, LabelServiceTest.descriptions);
			for (Label l : labels) {
				Assert.assertFalse(labelNumbers.contains(l.getLabelNumber()));
				labelNumbers.add(l.getLabelNumber());
			}
		}

	}

}
