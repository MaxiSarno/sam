package edu.uade.sam.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author msarno
 *
 */
public enum SensoryEvaluationScale {
	NINE("nueve", 1, 9), FIVE("cinco", 1, 5);

	private String name;
	private Integer lowerLimit;
	private Integer upperLimit;

	SensoryEvaluationScale(String name, Integer lowerLimit, Integer upperLimit) {
		this.name = name;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	public boolean contains(Integer number) {
		if (number != null && lowerLimit <= number && number <= upperLimit)
			return true;
		else
			return false;
	}

	@JsonValue
	public String getName() {
		return name;
	}

	public Integer getLowerLimit() {
		return lowerLimit;
	}

	public Integer getUpperLimit() {
		return upperLimit;
	}

	public static SensoryEvaluationScale fromString(String scale) {
		if (NINE.name.equalsIgnoreCase(scale))
			return NINE;
		else if (FIVE.name.equalsIgnoreCase(scale))
			return FIVE;
		else
			return null;
	}

}
