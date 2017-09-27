package edu.uade.sam.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	private String attributeName;
	private boolean areDifferent;
	private String winner;
	private Distribution distribution;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ResultSummary> summaries;

	public PartialResult() {
	}

	public PartialResult(String attributeName, Distribution distribution, boolean areDifferent, String winner,
			List<ResultSummary> summaries) {
		this.attributeName = attributeName;
		this.distribution = distribution;
		this.areDifferent = areDifferent;
		this.winner = winner;
		this.summaries = summaries;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public boolean getAreDifferent() {
		return areDifferent;
	}

	public void setAreDifferent(boolean areDifferent) {
		this.areDifferent = areDifferent;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Distribution getDistribution() {
		return distribution;
	}

	public void setDistribution(Distribution distribution) {
		this.distribution = distribution;
	}

	public List<ResultSummary> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<ResultSummary> summaries) {
		this.summaries = summaries;
	}

	@Override
	public String toString() {
		return "PartialResult [id=" + id + ", attributeName=" + attributeName + ", areDifferent=" + areDifferent
				+ ", distribution=" + distribution + ", summaries=" + summaries + "]";
	}

}
