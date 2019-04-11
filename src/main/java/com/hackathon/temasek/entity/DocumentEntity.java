package com.hackathon.temasek.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class DocumentEntity {
	@EmbeddedId
	private DocumentEmbedded documentEmbedded;

	public DocumentEmbedded getDocumentEmbedded() {
		return documentEmbedded;
	}

	public void setDocumentEmbedded(DocumentEmbedded documentEmbedded) {
		this.documentEmbedded = documentEmbedded;
	}
	
}
