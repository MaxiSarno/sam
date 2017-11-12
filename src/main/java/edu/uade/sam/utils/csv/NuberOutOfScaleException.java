package edu.uade.sam.utils.csv;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.SensoryEvaluationScale;

/**
 * @author msarno
 *
 */
public class NuberOutOfScaleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NuberOutOfScaleException() {
		super();
	}
	
	public NuberOutOfScaleException(SensoryEvaluationScale scale, NumericAttribute attribute) {
		super("El atributo " + attribute + " se encuentra fuera de la escala " + scale);
	}

}
