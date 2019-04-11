package com.hackathon.temasek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.temasek.entity.DocumentEmbedded;
import com.hackathon.temasek.entity.DocumentEntity;
import com.hackathon.temasek.entity.UserEntity;
@Repository
public interface DocumentRepository  extends JpaRepository<DocumentEntity, DocumentEmbedded> {

	List<DocumentEntity> findByDocumentEmbeddedUserId(String userId);
}
