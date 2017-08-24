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
	private long id;
	private String sampleName;
	private long count;
	private double sum;
	private double min;
	private double max;
	private double average;
	private double variance;

	public ResultSummary() {
	}

	public ResultSummary(String sampleName, long count, double sum, double min, double max, double average, double variance) {
		this.sampleName = sampleName;
		this.count = count;
		this.sum = sum;
		this.min = min;
		this.max = max;
		this.average = average;
		this.variance = variance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getVariance() {
		return variance;
	}

	public void setVariance(double variance) {
		this.variance = variance;
	}

	@Override
	public String toString() {
		return "ResultSummary [id=" + id + ", sampleName=" + sampleName + ", count=" + count + ", sum=" + sum + ", min="
				+ min + ", max=" + max + ", average=" + average + ", variance=" + variance + "]";
	}
	
}
