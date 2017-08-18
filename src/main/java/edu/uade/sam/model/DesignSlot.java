package edu.uade.sam.model;

import java.util.List;

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
	private final int judge;
	@OneToMany
	private final List<Label> labels;

	public DesignSlot(int i, List<Label> labels) {
		this.judge = i;
		this.labels = labels;
	}

	public int getJudge() {
		return judge;
	}

	public List<Label> getLabels() {
		return labels;
	}

	@Override
	public String toString() {
		return "TestDesignSlot [judge=" + judge + ", labels=" + labels + "]";
	}

}
