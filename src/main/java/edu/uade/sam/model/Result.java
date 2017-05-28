package edu.uade.sam.model;

import java.util.List;

/**
 * Resultado de la prueba producto de de evaluar los datos.
 * 
 * @author maxi
 *
 */
public class Result {

	private List<ResultSummary> summaries;

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<ResultSummary> summaries) {
		this.summaries = summaries;
	}

}
