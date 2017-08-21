package edu.uade.sam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Representa el resultado parcial de la prueba sobre un atributo determinado
 * 
 * @author msarno
 *
 */
@Entity
public class PartialResult {

	@Id
	@GeneratedValue
	private long id;
	private boolean areDifferent;
	private Distribution distribution;
	@OneToMany
	private List<ResultSummary> summaries;

	public PartialResult() {
	}

	public PartialResult(Distribution distribution, boolean areDifferent, List<ResultSummary> summaries) {
		this.distribution = distribution;
		this.areDifferent = areDifferent;
		this.summaries = summaries;
	}

	public Distribution getDistribution() {
		return distribution;
	}

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public boolean getAreDifferent() {
		return areDifferent;
	}

}
