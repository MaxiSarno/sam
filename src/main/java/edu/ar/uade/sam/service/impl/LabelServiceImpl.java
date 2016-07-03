package edu.ar.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ar.uade.sam.model.Label;
import edu.ar.uade.sam.service.LabelService;


public class LabelServiceImpl implements LabelService {
	
	private static final int LABEL_MAX_VALUE = 999;
	private static Map<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
	private static final List<Integer> numbers = LabelServiceImpl.numbers();
	
	private static List<Integer> numbers() {
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < LABEL_MAX_VALUE; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	public List<Label> createLabels(Integer testId, List<String> descriptions) {
		List<Label> labels = new ArrayList<Label>();
		
		for(String desc : descriptions) {
			Integer labelNumber = this.getLabelNumber(testId);
			Label label = new Label(labelNumber, desc);
			labels.add(label);
		}
		
		return labels;
	}

	private Integer getLabelNumber(Integer testId) {
		List<Integer> availableNumbers = this.getAvailableNumbers(testId);
		int index = this.randomBetween(availableNumbers.size());
		
		Integer labelNumber = availableNumbers.get(index);
		availableNumbers.remove(index);
		
		return labelNumber;
	}

	private List<Integer> getAvailableNumbers(Integer testId) {
		if (!cache.containsKey(testId)) {
			cache.put(testId, new ArrayList<Integer>(numbers));
		}
		return cache.get(testId);
	}

	private Integer randomBetween(int max) {
		return (int) (Math.random() * max);
	}
	
	public static void main(String[] args) {
		LabelService ls = new LabelServiceImpl();
		for (int i = 0;i<99; i++) {
			List<Label> labels = ls.createLabels(1, Arrays.asList("tang", "clight", "bc"));
			for(Label l : labels) {
				System.out.println(l);
			}
		}
	}
	
}
