package com.hackathon.temasek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.DocumentEmbedded;
import com.hackathon.temasek.entity.DocumentEntity;
import com.hackathon.temasek.entity.EmbeddedNotificationEntity;
import com.hackathon.temasek.entity.NotificationEntity;
import com.hackathon.temasek.model.Notification;
import com.hackathon.temasek.model.NotificationResponse;
import com.hackathon.temasek.model.ResponseBody;
import com.hackathon.temasek.repository.DocumentRepository;
import com.hackathon.temasek.repository.NotificationRepository;
import com.hackathon.temasek.utility.ApplicationConstants;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	public ResponseBody insertNotificationDocument(Notification notification) {
		
		EmbeddedNotificationEntity entity = new EmbeddedNotificationEntity();
		ResponseBody responseBody = new ResponseBody();
		try {
		entity.setSource(notification.getSourceUserId());
		entity.setDestination(notification.getDestinationUserId());
		entity.setDocPath(notification.getDocPath());
		entity.setName(notification.getName());
		NotificationEntity nentity = new NotificationEntity();
		nentity.setNotificationEmbedded(entity);
		notificationRepository.saveAndFlush(nentity);
		
		DocumentEntity dockEntity = new DocumentEntity();
		DocumentEmbedded em = new DocumentEmbedded();
		em.setUserId(notification.getDestinationUserId());
		em.setDocPath(notification.getDocPath());
		dockEntity.setDocumentEmbedded(em);
		dockEntity.setOwner(false);
		documentRepository.saveAndFlush(dockEntity);
		}catch(Exception e) {
			responseBody.setStatusCode(ApplicationConstants.FAILURE);
			responseBody.setStatusMessage(e.getMessage());
		}
		responseBody.setStatusCode(ApplicationConstants.SUCCESS);
		responseBody.setStatusMessage("Notified !!!");
		return responseBody;	
	}
	
	public List<NotificationEntity> getNotifications(String userId) {
		
		List<NotificationEntity> notificationEntityList= notificationRepository.findByNotificationEmbeddedDestination(userId);
		System.out.println("getnotification  ..."+notificationEntityList);
		if(notificationEntityList == null || notificationEntityList.size()==0)
			return null;
	   return notificationEntityList;
	}
}
