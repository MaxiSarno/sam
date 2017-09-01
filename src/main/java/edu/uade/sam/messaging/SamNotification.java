package edu.uade.sam.messaging;

/**
 * @author msarno
 *
 */
public class SamNotification {

	private int number;
	private String message;

	public static SamNotification fromCatalog(SamNotificationCatalog c) {
		return new SamNotification(c.id, c.description);
	}

	private SamNotification(int number, String message) {
		this.number = number;
		this.message = message;
	}

	public int getNumber() {
		return number;
	}

	public String getMessage() {
		return message;
	}

}
