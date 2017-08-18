package edu.uade.sam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Etiqueta para una muestra de una prueba, se usa para ofuscar la muestra para
 * los jueces.
 * 
 * @author maxi
 *
 */
@Entity
public class Label {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private Integer labelNumber;
	//FIXME sacar el test id
	@Transient
	private Long testId;
	@Column
	private String description;

	
	public Label() {}
	
	public Label(Long testId, Integer labelNumber, String desc) {
		this.testId = testId;
		this.labelNumber = labelNumber;
		this.description = desc;
	}

	public Long getTestId() {
		return testId;
	}

	public Integer getLabelNumber() {
		return labelNumber;
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLabelNumber(Integer labelNumber) {
		this.labelNumber = labelNumber;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Label [id=" + id + ", labelNumber=" + labelNumber + ", testId=" + testId + ", description="
				+ description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((labelNumber == null) ? 0 : labelNumber.hashCode());
		result = prime * result + ((testId == null) ? 0 : testId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Label other = (Label) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (labelNumber == null) {
			if (other.labelNumber != null)
				return false;
		} else if (!labelNumber.equals(other.labelNumber))
			return false;
		if (testId == null) {
			if (other.testId != null)
				return false;
		} else if (!testId.equals(other.testId))
			return false;
		return true;
	}

}
