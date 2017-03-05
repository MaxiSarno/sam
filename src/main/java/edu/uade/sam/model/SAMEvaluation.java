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
	private Design design;
	private Attribute attributes;
	//TODO Segmentation
	private TestResult result;

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

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Attribute getAttributes() {
		return attributes;
	}

	public void setAttributes(Attribute attributes) {
		this.attributes = attributes;
	}

	public TestResult getResult() {
		return result;
	}

	public void setResult(TestResult result) {
		this.result = result;
	}

}
