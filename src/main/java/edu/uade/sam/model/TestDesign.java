package edu.uade.sam.model;

import java.util.ArrayList;

/**
 * Diseño de una prueba con ciertas muestras para una poblacion especifica.
 * 
 * @author maxi
 *
 */
public class TestDesign {

	private Integer testId;
	private String testName;
	private ArrayList<TestDesignSlot> testSlots;

	public TestDesign(Integer testId, String testName) {
		this.testId = testId;
		this.testName = testName;
		this.testSlots = new ArrayList<TestDesignSlot>();
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public ArrayList<TestDesignSlot> getTestSlots() {
		return testSlots;
	}

	public void setTestSlots(ArrayList<TestDesignSlot> testSlots) {
		this.testSlots = testSlots;
	}

	@Override
	public String toString() {
		return "TestDesign [testId=" + testId + ", testName=" + testName
				+ ", testSlots=" + testSlots + "]";
	}

}
