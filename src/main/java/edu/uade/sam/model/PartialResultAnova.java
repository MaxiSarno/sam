package edu.uade.sam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author msarno
 *
 */
@Entity
public class PartialResultAnova extends PartialResult {

	private Double fValue;
	private Double fCritValue;
	private Double pValue;

	public PartialResultAnova() {
	}

	public PartialResultAnova(String attributeName, boolean areDifferent, List<ResultSummary> summaries, double fValue,
			double fCritValue, double pValue) {
		super(attributeName, Distribution.ANOVA, areDifferent, summaries);
		this.fValue = fValue;
		this.fCritValue = fCritValue;
		this.pValue = pValue;
	}

	@PrePersist
	@PreUpdate
	private void prePersist() {
		if (isFuckedUp(fValue))
			fValue = null;

		if (isFuckedUp(fCritValue))
			fCritValue = null;

		if (isFuckedUp(pValue))
			pValue = null;
	}

	private boolean isFuckedUp(Double value) {
		if (value == null || value.equals(Double.NaN) || value.equals(Double.POSITIVE_INFINITY)
				|| value.equals(Double.NEGATIVE_INFINITY)) {

			return true;
		} else {
			return false;
		}
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
