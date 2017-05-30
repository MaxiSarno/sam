package edu.uade.sam.model;

/**
 * Esta clase engloba todos los aspectos relacionados con la evaluación sensorial
 * 
 * @author maxi
 *
 */
public class SensoryEvaluation {
	
	private Integer testId;
	private String name;
	// private Design design;
	// private Attribute attributes;
	// //TODO Segmentation
	// private EvaluationResult result;

	public Integer getTestId() {
		return testId;
	}

	public void setId(Integer testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String testName) {
		this.name = testName;
	}

}
