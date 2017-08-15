package edu.uade.sam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Diseño de una prueba con ciertas muestras para una poblacion especifica.
 * 
 * @author maxi
 *
 */
public class Design {

	private long id;
	private final List<DesignSlot> designSlots;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Design() {
		this.designSlots = new ArrayList<DesignSlot>();
	}

	public List<DesignSlot> getDesignSlots() {
		return designSlots;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designSlots == null) ? 0 : designSlots.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Design other = (Design) obj;
		if (designSlots == null) {
			if (other.designSlots != null)
				return false;
		} else if (!designSlots.equals(other.designSlots))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Design [id=" + id + ", designSlots=" + designSlots + "]";
	}

}
