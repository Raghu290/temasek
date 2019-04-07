package com.hackathon.temasek.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.temasek.entity.EmbeddedNotificationEntity;
import com.hackathon.temasek.entity.NotificationEntity;


@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, EmbeddedNotificationEntity>{

	 List<NotificationEntity> findByNotificationEmbeddedSource(String source);

}
