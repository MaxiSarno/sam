package edu.uade.sam.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * @author msarno
 *
 */
@Entity
public class PartialResultStudent extends PartialResult {

	public PartialResultStudent() {
	}

	public PartialResultStudent(String attributeName, boolean areDifferent, List<ResultSummary> summaries) {
		super(attributeName, Distribution.STUDENT_T, areDifferent, summaries);
	}

}
