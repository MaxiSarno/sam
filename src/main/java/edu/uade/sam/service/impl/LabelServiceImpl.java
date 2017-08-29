package edu.uade.sam.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.uade.sam.model.Label;
import edu.uade.sam.service.LabelService;

/**
 * @author msarno
 *
 */
public class LabelServiceImpl implements LabelService {
	
	public static final int LABEL_MAX_VALUE = 999;
	private List<Integer> availableNumbers;
	
	public LabelServiceImpl() {
		this.availableNumbers = this.initNumbers();
	}
	
	private List<Integer> initNumbers() {
		List<Integer> numbers = Collections.synchronizedList(new ArrayList<Integer>());
		
		for(int i = 0; i < LABEL_MAX_VALUE; i++) {
			numbers.add(i);
		}
		
		return numbers;
	}

	public List<Label> createLabels(List<String> descriptions) {
		List<Label> labels = new ArrayList<Label>();
		
		for(String desc : descriptions) {
			Integer labelNumber = this.getLabelNumber();
			Label label = new Label(labelNumber, desc);
			labels.add(label);
		}
		
		return labels;
	}

	private Integer getLabelNumber() {
		int index = this.randomBetween(availableNumbers.size());
		
		Integer labelNumber = availableNumbers.get(index);
		availableNumbers.remove(index);
		
		return labelNumber;
	}

	private Integer randomBetween(int max) {
		return (int) (Math.random() * max);
	}
	
}
