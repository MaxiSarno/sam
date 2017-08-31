package edu.uade.sam.model;

/**
 * @author msarno
 *
 */
public enum SensoryEvaluationScale {
	NINE(1, 9), FIVE(1, 5);

	private Integer lowerLimit;
	private Integer upperLimit;

	SensoryEvaluationScale(Integer lowerLimit, Integer upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	public boolean contains(Integer number) {
		if (number != null && lowerLimit <= number && number <= upperLimit)
			return true;
		else
			return false;
	}

	public Integer getLowerLimit() {
		return lowerLimit;
	}

	public Integer getUpperLimit() {
		return upperLimit;
	}

	public static SensoryEvaluationScale fromString(String scale) {
		if (NINE.toString().equalsIgnoreCase(scale))
			return NINE;
		else if (FIVE.toString().equalsIgnoreCase(scale))
			return FIVE;
		else
			return null;
	}

}
