package edu.uade.sam.model;

import java.util.List;

/**
 * Representa el resultado parcial de la prueba sobre un atributo determinado
 * 
 * @author msarno
 *
 */
public class PartialResult {
	
	private List<ResultSummary> summaries;
	private boolean areDifferent;

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<ResultSummary> summaries) {
		this.summaries = summaries;
	}

	public boolean areDifferent() {
		return areDifferent;
	}

	public void setAreDifferent(boolean areDifferent) {
		this.areDifferent = areDifferent;
	}

}
