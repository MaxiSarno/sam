package edu.uade.sam.model;

public class ResultSummary {

	private final long count;
	private final double sum;
	private final double average;
	private final double variance;

	public ResultSummary(long count, double sum, double average, double variance) {
		this.count = count;
		this.sum = sum;
		this.average = average;
		this.variance = variance;
	}

	public long getCount() {
		return count;
	}

	public double getSum() {
		return sum;
	}

	public double getAverage() {
		return average;
	}

	public double getVariance() {
		return variance;
	}

}
