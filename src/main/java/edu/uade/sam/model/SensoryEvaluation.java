package edu.uade.sam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Esta clase engloba todos los aspectos relacionados con la evaluación sensorial
 * 
 * @author maxi
 *
 */
@Entity
public class SensoryEvaluation {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long testId;
	private String name;
	// private Design design;
	// private Attribute attributes;
	// //TODO Segmentation
	// private EvaluationResult result;

	public Long getTestId() {
		return testId;
	}

	public void setId(Long testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String testName) {
		this.name = testName;
	}

}
