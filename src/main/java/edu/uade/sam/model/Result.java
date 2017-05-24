package edu.uade.sam.model;

/**
 * Resultado de la prueba producto de de evaluar los datos.
 * 
 * @author maxi
 *
 */
public class Result {

	private double fValue;
	private double fCritValue;
	private double pValue;
	private boolean testValue;

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

	public boolean isTestValue() {
		return testValue;
	}

	public void setTestValue(boolean testValue) {
		this.testValue = testValue;
	}
}
