package com.hackathon.temasek.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Embeddable
public class EmbeddedNotificationEntity  implements Serializable{

	@NotNull
	private String source;
	
	@NotNull
	private String destination;
	
	@NotNull
	private String document;
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
