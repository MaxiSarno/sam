package edu.uade.sam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author msarno
 *
 */
@Entity
public class ResultSummary {

	@Id
	@GeneratedValue
	private String name;
	private long count;
	private double sum;
	private double min;
	private double max;
	private double average;
	private double variance;

	public ResultSummary() {
	}

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

	@Override
	public String toString() {
		return "ResultSummary [name=" + name + ", count=" + count + ", sum=" + sum + ", min=" + min + ", max=" + max
				+ ", average=" + average + ", variance=" + variance + "]";
	}
	
}
