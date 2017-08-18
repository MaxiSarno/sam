package edu.uade.sam.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Diseño de una prueba, solo la parte que aplica a un juez en particular.
 * 
 * @author maxi
 *
 */
@Entity
public class DesignSlot {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private int judge;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Label> labels;

	
	public DesignSlot() {}
	
	public DesignSlot(int judge, List<Label> labels) {
		this.judge = judge;
		this.labels = labels;
	}

	public int getJudge() {
		return judge;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setJudge(int judge) {
		this.judge = judge;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	@Override
	public String toString() {
		return "TestDesignSlot [judge=" + judge + ", labels=" + labels + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + judge;
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
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
		DesignSlot other = (DesignSlot) obj;
		if (id != other.id)
			return false;
		if (judge != other.judge)
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		return true;
	}

}
