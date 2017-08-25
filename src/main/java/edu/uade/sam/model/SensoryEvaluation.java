package edu.uade.sam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Esta clase engloba todos los aspectos relacionados con la evaluación
 * sensorial
 * 
 * @author maxi
 *
 */
@Entity
public class SensoryEvaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long samId;
	private String name;
	private SensoryEvaluationType type;
	// private Design design;
	// private Attribute attributes;
	// private EvaluationResult result;

	public SensoryEvaluation() {
	}

	public SensoryEvaluation(String name, SensoryEvaluationType type) {
		this.name = name;
		this.type = type;
	}

	public Long getSamId() {
		return samId;
	}

	public void setSamId(Long samId) {
		this.samId = samId;
	}

	public String getName() {
		return name;
	}

	public void setName(String testName) {
		this.name = testName;
	}

	public SensoryEvaluationType getType() {
		return type;
	}

	public void setType(SensoryEvaluationType type) {
		this.type = type;
	}

}
