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
	private long samId;
	private Integer judges;
	private String samples;
	@OneToMany(cascade = CascadeType.ALL)
	private List<DesignSlot> designSlots;

	public Design() {
	}

	public Design(long samId, Integer judges, String samples, List<DesignSlot> designSlots) {
		this.judges = judges;
		this.samples = samples;
		this.samId = samId;
		this.designSlots = designSlots;
	}

	public long getSamId() {
		return samId;
	}

	public void setSamId(long samId) {
		this.samId = samId;
	}

	public Integer getJudges() {
		return judges;
	}

	public void setJudges(Integer judges) {
		this.judges = judges;
	}

	public String getSamples() {
		return samples;
	}

	public void setSamples(String samples) {
		this.samples = samples;
	}

	public List<DesignSlot> getDesignSlots() {
		return designSlots;
	}

	public void setDesignSlots(List<DesignSlot> designSlots) {
		this.designSlots = designSlots;
	}

}
