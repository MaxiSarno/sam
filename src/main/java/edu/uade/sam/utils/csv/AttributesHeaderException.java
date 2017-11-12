package edu.uade.sam.utils.csv;

/**
 * @author msarno
 *
 */
public class AttributesHeaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AttributesHeaderException() {}
	
	public AttributesHeaderException(String message) {
		super ("Error en los encabezados de la tabla:"+message);
	}

}
