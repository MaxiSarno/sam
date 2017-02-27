package edu.uade.model;

public class EvaluationResult {

	private Integer labelNumber;
	private String comments;
	private Evaluation eval;

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

	public Evaluation getEval() {
		return eval;
	}

	public void setEval(Evaluation eval) {
		this.eval = eval;
	}

}
