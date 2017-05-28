package edu.uade.sam.model;

/**
 * @author msarno
 *
 */
public class ResultSummary {

	private final String name;
	private final long count;
	private final double sum;
	private final double min;
	private final double max;
	private final double average;
	private final double variance;

	public ResultSummary(String name, long count, double sum, double min, double max, double average, double variance) {
		this.name = name;
		this.count = count;
		this.sum = sum;
		this.min = min;
		this.max = max;
		this.average = average;
		this.variance = variance;
	}

	public String getName() {
		return name;
	}

	public long getCount() {
		return count;
	}

	public double getSum() {
		return sum;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public double getAverage() {
		return average;
	}

	public double getVariance() {
		return variance;
	}

}
