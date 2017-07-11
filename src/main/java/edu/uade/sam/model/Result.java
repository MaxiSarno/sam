package edu.uade.sam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Resultado de la prueba producto de de evaluar los datos.
 * 
 * @author maxi
 *
 */
public class Result {
	
	private final float alpha;
	private final List<PartialResult> partialResults;
	
	public Result(float alpha) {
		this.alpha = alpha;
		this.partialResults = new ArrayList<>();
	}

	public float getAlpha() {
		return alpha;
	}

	public List<PartialResult> getPartialResults() {
		return partialResults;
	}

}
