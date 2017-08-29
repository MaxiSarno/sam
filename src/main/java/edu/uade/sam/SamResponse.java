package edu.uade.sam;

/**
 * @author msarno
 *
 */
public class SamResponse {

	private Object data;
	private SamNotification notification;

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

}
