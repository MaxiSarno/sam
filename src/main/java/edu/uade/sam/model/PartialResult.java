package edu.uade.sam.model;

import java.util.List;

/**
 * Representa el resultado parcial de la prueba sobre un atributo determinado
 * 
 * @author msarno
 *
 */
public class PartialResult {
	
	private final List<ResultSummary> summaries;
	private final boolean areDifferent;
	
	public PartialResult(boolean areDifferent, List<ResultSummary> summaries) {
		this.areDifferent = areDifferent;
		this.summaries = summaries;
	}

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public boolean areDifferent() {
		return areDifferent;
	}

}
