package edu.uade.sam.model;

public class EvaluationResult {

	private Integer labelNumber;
	private String comments;
	private Attribute eval;

	public Integer getLabelNumber() {
		return labelNumber;
	}

	public void setLabelNumber(Integer labelNumber) {
		this.labelNumber = labelNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Attribute getEval() {
		return eval;
	}

	public void setEval(Attribute eval) {
		this.eval = eval;
	}

}
