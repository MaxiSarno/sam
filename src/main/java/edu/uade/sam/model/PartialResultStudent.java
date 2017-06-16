package edu.uade.sam.model;

import java.util.List;

/**
 * @author msarno
 *
 */
public class PartialResultStudent extends PartialResult {

	public PartialResultStudent(boolean areDifferent, List<ResultSummary> summaries) {
		super(areDifferent, summaries);
	}

}
