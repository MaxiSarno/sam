package edu.uade.sam.model;

/**
 * @author msarno
 *
 */
public enum SensoryEvaluationType {
	CONSUMER("consumer"), HEDONIC("hedonic"), DESCRIPTIVE("descriptive");

	private String value;

	SensoryEvaluationType(String v) {
		this.value = v;
	}

	public String getValue() {
		return value;
	}

	static public SensoryEvaluationType fromString(String value) {
		if (CONSUMER.value.equals(value)) {
			return CONSUMER;
		} else if (HEDONIC.value.equals(value)) {
			return HEDONIC;
		} else if (DESCRIPTIVE.value.equals(value)) {
			return DESCRIPTIVE;
		}
		return null;
	}

}
