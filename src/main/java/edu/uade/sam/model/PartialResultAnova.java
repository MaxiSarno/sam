package edu.uade.sam.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * @author msarno
 *
 */
@Entity
public class PartialResultAnova extends PartialResult {

	private double fValue;
	private double fCritValue;
	private double pValue;

	public PartialResultAnova() {
	}

	public PartialResultAnova(String attributeName, boolean areDifferent, List<ResultSummary> summaries, double fValue,
			double fCritValue, double pValue) {
		super(attributeName, Distribution.ANOVA, areDifferent, summaries);
		this.fValue = fValue;
		this.fCritValue = fCritValue;
		this.pValue = pValue;
	}

	public double getfValue() {
		return fValue;
	}

	public void setfValue(double fValue) {
		this.fValue = fValue;
	}

	public double getfCritValue() {
		return fCritValue;
	}

	public void setfCritValue(double fCritValue) {
		this.fCritValue = fCritValue;
	}

	public double getpValue() {
		return pValue;
	}

	public void setpValue(double pValue) {
		this.pValue = pValue;
	}

}
