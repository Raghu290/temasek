package com.hackathon.temasek.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class NotificationEntity {
	
	@EmbeddedId
	private EmbeddedNotificationEntity notificationEmbedded;

	public EmbeddedNotificationEntity getNotificationEmbedded() {
		return notificationEmbedded;
	}

	public void setNotificationEmbedded(EmbeddedNotificationEntity notificationEmbedded) {
		this.notificationEmbedded = notificationEmbedded;
	}
	

	

}
