package com.hackathon.temasek.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.temasek.entity.NotificationEntity;
import com.hackathon.temasek.entity.UserEntity;
import com.hackathon.temasek.model.Login;
import com.hackathon.temasek.model.Notification;
import com.hackathon.temasek.model.NotificationResponse;
import com.hackathon.temasek.model.ResponseBody;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.service.NotificationService;

@RestController
public class NotificationController  {
	
	@Autowired
	private NotificationService notificationService;

	@RequestMapping(value = "/shareDocument", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBody shareDocument(@RequestBody Notification notification) {	
	
		return notificationService.insertNotificationDocument(notification);
	}
    	
	@RequestMapping(value = "/getNotifications", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<NotificationEntity> getNotifications(@RequestBody User user) {	
	
		return notificationService.getNotifications(user.getUserId());
	}
}
