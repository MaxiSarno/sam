package edu.uade.sam.model;

import java.util.List;

/**
 * Diseño de una prueba, solo la parte que aplica a un juez en particular.
 * 
 * @author maxi
 *
 */
public class DesignSlot {

	private final int judge;
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
