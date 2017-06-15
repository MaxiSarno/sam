package edu.uade.sam.model;

import java.util.List;

/**
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
