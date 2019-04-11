package com.hackathon.temasek.model;

import java.util.List;

import com.hackathon.temasek.entity.NotificationEntity;

public class NotificationResponse extends ResponseBody{
 
	List<NotificationEntity> notificationEntityList;

	public List<NotificationEntity> getNotificationEntityList() {
		return notificationEntityList;
	}

	public void setNotificationEntityList(List<NotificationEntity> notificationEntityList) {
		this.notificationEntityList = notificationEntityList;
	}
}
