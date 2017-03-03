package edu.uade.sam.model;

import java.util.ArrayList;

/**
 * Diseño de una prueba con ciertas muestras para una poblacion especifica.
 * 
 * @author maxi
 *
 */
public class Design {

	
	private ArrayList<TestDesignSlot> testSlots;

	public Design() {
		this.testSlots = new ArrayList<TestDesignSlot>();
	}

	public ArrayList<TestDesignSlot> getTestSlots() {
		return testSlots;
	}

	public void setTestSlots(ArrayList<TestDesignSlot> testSlots) {
		this.testSlots = testSlots;
	}

	@Override
	public String toString() {
		return "TestDesign [testSlots=" + testSlots + "]";
	}

}
