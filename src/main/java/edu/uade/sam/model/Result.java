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
	
	private final List<PartialResult> partialResults;
	
	public Result() {
		this.partialResults = new ArrayList<>();
	}

	public List<PartialResult> getPartialResults() {
		return partialResults;
	}

}
