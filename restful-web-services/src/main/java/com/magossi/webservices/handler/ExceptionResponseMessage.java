package com.magossi.webservices.handler;

import java.util.Date;

public class ExceptionResponseMessage {

	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponseMessage(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
