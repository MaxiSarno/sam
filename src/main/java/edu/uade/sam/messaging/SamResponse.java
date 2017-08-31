package edu.uade.sam.messaging;

/**
 * @author msarno
 *
 */
public class SamResponse {

	private Object data;
	private SamNotification notification;
	
	public SamResponse() {
	}
	
	public SamResponse(Object data, SamNotification notification) {
		this.data = data;
		this.notification = notification;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public SamNotification getNotification() {
		return notification;
	}

	public void setNotification(SamNotification notification) {
		this.notification = notification;
	}
	
	public static SamResponse data(Object data) {
		return new SamResponse(data, null);
	}
	
	public static SamResponse notification(SamNotification notification) {
		return new SamResponse(null, notification);
	}
	
}
