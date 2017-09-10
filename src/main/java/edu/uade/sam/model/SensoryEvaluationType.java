package edu.uade.sam.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author msarno
 *
 */
public enum SensoryEvaluationType {
	CONSUMER("consumidor"), HEDONIC("hedonica"), DESCRIPTIVE("descriptiva");

	private String name;

	SensoryEvaluationType(String v) {
		this.name = v;
	}

	@JsonValue
	public String getName() {
		return name;
	}

	static public SensoryEvaluationType fromString(String value) {
		if (CONSUMER.name.equalsIgnoreCase(value)) {
			return CONSUMER;
		} else if (HEDONIC.name.equalsIgnoreCase(value)) {
			return HEDONIC;
		} else if (DESCRIPTIVE.name.equalsIgnoreCase(value)) {
			return DESCRIPTIVE;
		}
		return null;
	}

}
