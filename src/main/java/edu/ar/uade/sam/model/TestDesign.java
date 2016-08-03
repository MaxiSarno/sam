package edu.ar.uade.sam.model;

import java.util.ArrayList;

public class TestDesign {

	private Integer testId;
	private ArrayList<TestSubject> tests;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public ArrayList<TestSubject> getTests() {
		return tests;
	}

	public void setTests(ArrayList<TestSubject> tests) {
		this.tests = tests;
	}

	public TestDesign(Integer testId) {
		this.testId = testId;
		this.tests = new ArrayList<TestSubject>();
	}

}
