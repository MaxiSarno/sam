package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.uade.sam.model.Label;
import edu.uade.sam.service.LabelService;

@Component
public class LabelServiceImpl implements LabelService {
	
	public static final int LABEL_MAX_VALUE = 999;
	
	private static Map<Long, List<Integer>> cache = new HashMap<Long, List<Integer>>();
	private static final List<Integer> numbers = LabelServiceImpl.setupNumbers();
	
	private static List<Integer> setupNumbers() {
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < LABEL_MAX_VALUE; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	public List<Label> createLabels(Long testId, List<String> descriptions) {
		List<Label> labels = new ArrayList<Label>();
		
		for(String desc : descriptions) {
			Integer labelNumber = this.getLabelNumber(testId);
			Label label = new Label(labelNumber, desc);
			labels.add(label);
		}
		
		return labels;
	}

	private Integer getLabelNumber(Long testId) {
		List<Integer> availableNumbers = this.getAvailableNumbers(testId);
		int index = this.randomBetween(availableNumbers.size());
		
		Integer labelNumber = availableNumbers.get(index);
		availableNumbers.remove(index);
		
		return labelNumber;
	}

	private List<Integer> getAvailableNumbers(Long testId) {
		if (!cache.containsKey(testId)) {
			cache.put(testId, new ArrayList<Integer>(numbers));
		}
		return cache.get(testId);
	}

	private Integer randomBetween(int max) {
		return (int) (Math.random() * max);
	}
	
}
