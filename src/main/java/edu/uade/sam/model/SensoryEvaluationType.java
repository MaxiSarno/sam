package edu.uade.sam.model;

/**
 * @author msarno
 *
 */
public enum SensoryEvaluationType {
	CONSUMER("consumer"), HEDONIC("hedonic"), PREFERENCE("preference");

	private String value;

	SensoryEvaluationType(String v) {
		this.value = v;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	static public SensoryEvaluationType fromString(String value) {
		if (CONSUMER.value.equals(value)) {
			return CONSUMER;
		} else if (HEDONIC.value.equals(value)) {
			return HEDONIC;
		} else if (PREFERENCE.value.equals(value)) {
			return PREFERENCE;
		}
		return null;
	}

}
