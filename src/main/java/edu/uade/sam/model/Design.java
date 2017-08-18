package edu.uade.sam.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private final long sensoryEvaluationId;

	@OneToMany(cascade=CascadeType.ALL)
	private final List<DesignSlot> designSlots;
	
	
	public Design(long sensoryEvaluationId, List<DesignSlot> designSlots) {
		this.sensoryEvaluationId = sensoryEvaluationId;
		this.designSlots = designSlots;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSensoryEvaluationId() {
		return sensoryEvaluationId;
	}

	public List<DesignSlot> getDesignSlots() {
		return designSlots;
	}

	@Override
	public String toString() {
		return "Design [id=" + id + ", sensoryEvaluationId=" + sensoryEvaluationId + ", designSlots=" + designSlots
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designSlots == null) ? 0 : designSlots.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		if (sensoryEvaluationId != other.sensoryEvaluationId)
			return false;
		return true;
	}

}
