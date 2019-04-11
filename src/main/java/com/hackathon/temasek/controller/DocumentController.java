package com.hackathon.temasek.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.temasek.entity.DocumentEntity;
import com.hackathon.temasek.model.Document;
import com.hackathon.temasek.model.ResponseBody;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.service.DocumentService;
import com.hackathon.temasek.service.LoginService;

@RestController
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value = "/insertDocument", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBody insertDocument(@RequestBody Document document) {		

		return documentService.insertDocService(document);
		
		
	}
	
	@RequestMapping(value = "/getUserDoc", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<DocumentEntity>  insertDocument(@RequestBody User user) {		

		return documentService.getUserDocs(user.getUserId());
		
		
	}
}
