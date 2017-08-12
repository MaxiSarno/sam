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
	private final Distribution distribution;
	
	public PartialResult(Distribution distribution, boolean areDifferent, List<ResultSummary> summaries) {
		this.distribution = distribution;
		this.areDifferent = areDifferent;
		this.summaries = summaries;
	}

	public Distribution getDistribution() {
		return distribution;
	}

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public boolean getAreDifferent() {
		return areDifferent;
	}

}
