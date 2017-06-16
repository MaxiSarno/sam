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

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<ResultSummary> summaries) {
		this.summaries = summaries;
	}

}
