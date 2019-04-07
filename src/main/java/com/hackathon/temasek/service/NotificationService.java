package com.hackathon.temasek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.EmbeddedNotificationEntity;
import com.hackathon.temasek.entity.NotificationEntity;
import com.hackathon.temasek.model.Notification;
import com.hackathon.temasek.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public String insertNotificationDocument(Notification notification) {
		
		EmbeddedNotificationEntity entity = new EmbeddedNotificationEntity();
		
		entity.setSource(notification.getSourceUserId());
		entity.setDestination(notification.getDestinationUserId());
		entity.setDocument(notification.getDocName());
		NotificationEntity nentity = new NotificationEntity();
		nentity.setNotificationEmbedded(entity);
		notificationRepository.saveAndFlush(nentity);
		return "success";
	}
	
	public List<NotificationEntity> getNotifications(String userId) {
		
		return notificationRepository.findByNotificationEmbeddedSource(userId);
	}
}
