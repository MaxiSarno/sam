package edu.uade.sam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Resultado de la prueba producto de de evaluar los datos.
 * 
 * @author maxi
 *
 */
@Entity
public class Result {

	@Id
	private long samId;
	private float alpha;
	@OneToMany(cascade=CascadeType.ALL)
	private List<PartialResult> partialResults;

	public Result() {
	}

	public Result(long samid, float alpha) {
		this.samId = samid;
		this.alpha = alpha;
		this.partialResults = new ArrayList<>();
	}

	public long getSamId() {
		return samId;
	}

	public void setSamId(long samId) {
		this.samId = samId;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public List<PartialResult> getPartialResults() {
		return partialResults;
	}

	public void setPartialResults(List<PartialResult> partialResults) {
		this.partialResults = partialResults;
	}

	@Override
	public String toString() {
		return "Result [samId=" + samId + ", alpha=" + alpha + ", partialResults=" + partialResults + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(alpha);
		result = prime * result + ((partialResults == null) ? 0 : partialResults.hashCode());
		result = prime * result + (int) (samId ^ (samId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (Float.floatToIntBits(alpha) != Float.floatToIntBits(other.alpha))
			return false;
		if (partialResults == null) {
			if (other.partialResults != null)
				return false;
		} else if (!partialResults.equals(other.partialResults))
			return false;
		if (samId != other.samId)
			return false;
		return true;
	}

}
