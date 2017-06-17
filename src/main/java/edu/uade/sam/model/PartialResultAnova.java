package edu.uade.sam.model;

import java.util.List;

/**
 * @author msarno
 *
 */
public class PartialResultAnova extends PartialResult {

	private final double fValue;
	private final double fCritValue;
	private final double pValue;
	
	public PartialResultAnova(boolean areDifferent, List<ResultSummary> summaries, double fValue, double fCritValue, double pValue) {
		super(areDifferent, summaries);
		this.fValue = fValue;
		this.fCritValue = fCritValue;
		this.pValue = pValue;
	}

	public double getfValue() {
		return fValue;
	}

	public double getfCritValue() {
		return fCritValue;
	}

	public double getpValue() {
		return pValue;
	}

}
