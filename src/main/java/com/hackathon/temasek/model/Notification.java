package com.hackathon.temasek.model;

public class Notification {


	private String sourceUserId;
	private String destinationUserId;
	private String name;
	private String docPath;
	
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
	
	
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
