package com.hackathon.temasek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.DocumentEmbedded;
import com.hackathon.temasek.entity.DocumentEntity;
import com.hackathon.temasek.model.Document;
import com.hackathon.temasek.model.ResponseBody;
import com.hackathon.temasek.repository.DocumentRepository;
import com.hackathon.temasek.utility.ApplicationConstants;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	public ResponseBody insertDocService(Document document) {
		ResponseBody response = new ResponseBody();
		try {
			DocumentEmbedded entity = new DocumentEmbedded();
		entity.setUserId(document.getUserId());
		entity.setDocPath(document.getDocPath());
		
		DocumentEntity docEntity = new DocumentEntity();
		docEntity.setDocumentEmbedded(entity);
		documentRepository.saveAndFlush(docEntity);
		
		response.setStatusCode(ApplicationConstants.SUCCESS);
		response.setStatusMessage("document inserted !!!");
		}catch(Exception e) {
			response.setStatusCode(ApplicationConstants.FAILURE);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}
	
	public List<DocumentEntity> getUserDocs(String userId) {
		
		List<DocumentEntity> docList = documentRepository.findByDocumentEmbeddedUserId(userId);
		if(docList == null || docList.size()==00)
			return null;
		return docList;
	}
}
