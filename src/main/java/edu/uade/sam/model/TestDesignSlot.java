package edu.uade.sam.model;

import java.util.List;

/**
 * Diseño de una prueba, solo la parte que aplica a un juez en particular.
 * 
 * @author maxi
 *
 */
public class TestDesignSlot {

	private int judge;
	private List<Label> labels;

	public TestDesignSlot(int i, List<Label> labels) {
		this.judge = i;
		this.labels = labels;
	}

	public int getJudge() {
		return judge;
	}

	public void setJudge(int judge) {
		this.judge = judge;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	@Override
	public String toString() {
		return "TestDesignSlot [judge=" + judge + ", labels=" + labels + "]";
	}

}
