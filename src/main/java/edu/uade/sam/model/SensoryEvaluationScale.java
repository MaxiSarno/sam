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

	public boolean belongs(Integer number) {
		if (lowerLimit <= number && number <= upperLimit)
			return true;
		else
			return false;
	}

	public Integer getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public Integer getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
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
