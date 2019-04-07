package com.hackathon.temasek.model;

public class Notification {


	private String sourceUserId;
	public String getSourceUserId() {
		return sourceUserId;
	}
	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	public String getDestinationUserId() {
		return destinationUserId;
	}
	public void setDestinationUserId(String destinationUserId) {
		this.destinationUserId = destinationUserId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	private String destinationUserId;
	private String docName;
}
