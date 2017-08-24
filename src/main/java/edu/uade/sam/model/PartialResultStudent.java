package edu.uade.sam.model;

import java.util.List;

/**
 * @author msarno
 *
 */
public class PartialResultStudent extends PartialResult {
	
	public PartialResultStudent(String attributeName, boolean areDifferent, List<ResultSummary> summaries) {
		super(attributeName, Distribution.STUDENT_T, areDifferent, summaries);
	}

}
