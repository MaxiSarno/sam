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
	private ArrayList<TestDesignSlot> testSlots;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public ArrayList<TestDesignSlot> getTestSlots() {
		return testSlots;
	}

	public void setTestSlots(ArrayList<TestDesignSlot> testSlots) {
		this.testSlots = testSlots;
	}

	public TestDesign(Integer testId) {
		this.testId = testId;
		this.testSlots = new ArrayList<TestDesignSlot>();
	}

}
