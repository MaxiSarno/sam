package edu.uade.sam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Esta clase engloba todos los aspectos relacionados con la evaluación
 * sensorial.
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
	@Enumerated(EnumType.STRING)
	private SensoryEvaluationType type;
	@Enumerated(EnumType.STRING)
	private SensoryEvaluationScale scale;
	private Date created;
	private String author;

	public SensoryEvaluation() {
	}

	public SensoryEvaluation(String name, SensoryEvaluationType type, SensoryEvaluationScale scale, String author) {
		this.name = name;
		this.type = type;
		this.scale = scale;
		this.created = new Date();
		this.author = author;

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

	public SensoryEvaluationScale getScale() {
		return scale;
	}

	public void setScale(SensoryEvaluationScale scale) {
		this.scale = scale;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", locale = "es_AR")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
