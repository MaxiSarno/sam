package edu.uade.sam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

/**
 * Diseño de una prueba con ciertas muestras para una poblacion especifica.
 * 
 * @author maxi
 *
 */
public class Design {

	private final List<DesignSlot> designSlots;

	public Design() {
		this.designSlots = new ArrayList<DesignSlot>();
	}

	public List<DesignSlot> getDesignSlots() {
		return designSlots;
	}

	@Override
	public String toString() {
		return "Design [designSlots=" + designSlots + "]";
	}

}
