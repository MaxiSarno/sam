package edu.uade.sam.model;

/**
 * Esta clase engloba todos los aspectos relacionados con la evaluación sensorial
 * 
 * @author maxi
 *
 */
public class SAMEvaluation {
	
	private Integer testId;
	private String name;
	private Design design;
	private Attribute attributes;
	//TODO Segmentation
	private Result result;

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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
