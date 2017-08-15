package edu.uade.sam.model;

/**
 * Etiqueta para una muestra de una prueba, se usa para ofuscar la muestra para
 * los jueces.
 * 
 * @author maxi
 *
 */
public class Label {

	private final Long testId;
	private final Integer labelNumber;
	private final String description;

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

	@Override
	public String toString() {
		return "Label [testId=" + testId + ", labelNumber=" + labelNumber
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
