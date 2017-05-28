package edu.uade.sam.model;

/**
 * @author msarno
 *
 */
public class ResultAnova extends Result {

	private double fValue;
	private double fCritValue;
	private double pValue;
	private boolean rejectH0;

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

	public boolean isRejectH0() {
		return rejectH0;
	}

	public void setRejectH0(boolean rejectH0) {
		this.rejectH0 = rejectH0;
	}

}
