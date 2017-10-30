package edu.uade.sam.exception;

/**
 * @author msarno
 *
 */
public class InvalidPasswordException extends SamException {

	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String msg) {
		super(msg);
	}

}
