package edu.uade.sam.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Diseño de una prueba con ciertas muestras para una poblacion especifica.
 * 
 * @author maxi
 *
 */
@Entity
public class Design {

	@Id
	private long sensoryEvaluationId;

	@OneToMany(cascade=CascadeType.ALL)
	private List<DesignSlot> designSlots;
	
	
	//for hibernate
	public Design() {}
	
	public Design(long sensoryEvaluationId, List<DesignSlot> designSlots) {
		this.sensoryEvaluationId = sensoryEvaluationId;
		this.designSlots = designSlots;
	}

	public long getSensoryEvaluationId() {
		return sensoryEvaluationId;
	}

	public List<DesignSlot> getDesignSlots() {
		return designSlots;
	}

	public void setSensoryEvaluationId(long sensoryEvaluationId) {
		this.sensoryEvaluationId = sensoryEvaluationId;
	}

	public void setDesignSlots(List<DesignSlot> designSlots) {
		this.designSlots = designSlots;
	}

	@Override
	public String toString() {
		return "Design [sensoryEvaluationId=" + sensoryEvaluationId + ", designSlots=" + designSlots + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designSlots == null) ? 0 : designSlots.hashCode());
		result = prime * result + (int) (sensoryEvaluationId ^ (sensoryEvaluationId >>> 32));
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
		if (sensoryEvaluationId != other.sensoryEvaluationId)
			return false;
		return true;
	}

}
