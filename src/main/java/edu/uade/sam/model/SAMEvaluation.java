package edu.uade.sam.model;

/**
 * Esta clase engloba todos los aspectos relacionados con la evaluación sensorial
 * 
 * @author maxi
 *
 */
public class SAMEvaluation {
	
	private Integer testId;
	private String testName;

	// private Design design;
	// private Attribute attributes;
	// //TODO Segmentation
	// private EvaluationResult result;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

}
