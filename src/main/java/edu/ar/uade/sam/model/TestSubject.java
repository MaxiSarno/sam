package edu.ar.uade.sam.model;

import java.util.List;

public class TestSubject {

	private int subject;
	private List<Label> labels;

	public TestSubject(int i, List<Label> labels) {
		this.subject = i;
		this.labels = labels;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

}
