package edu.uade.sam.model;

/**
 * @author msarno
 *
 */
public class PartialResultAnova extends PartialResult {

	private double fValue;
	private double fCritValue;
	private double pValue;

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
