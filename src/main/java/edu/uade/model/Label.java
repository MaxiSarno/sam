package edu.uade.model;

/**
 * Etiqueta para una muestrade una prueba, se usa para ofuscar la muestra para los jueces.
 * 
 * @author maxi
 *
 */
public class Label {
	
	private Integer id;
	private Integer testId;
	private Integer labelNumber;
	private String description;

	public Label(Integer testId, Integer labelNumber, String desc) {
		this.testId = testId;
		this.labelNumber = labelNumber;
		this.description = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Integer getLabelNumber() {
		return labelNumber;
	}

	public void setLabelNumber(Integer labelNumber) {
		this.labelNumber = labelNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Label [id=" + id + ", testId=" + testId + ", labelNumber="
				+ labelNumber + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + labelNumber;
		result = prime * result + testId;
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
		if (labelNumber != other.labelNumber)
			return false;
		if (testId != other.testId)
			return false;
		return true;
	}

}
