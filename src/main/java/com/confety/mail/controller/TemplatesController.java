package com.confety.mail.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



public interface TemplatesController {

//private String title;
//	
//	private String description;
//	
//	private ;

	
	@PostMapping("/Save")
	public ResponseEntity<?> saveNewTemplate(@RequestParam("file") MultipartFile templateFile ,@RequestHeader("title") String title , @RequestHeader("description") String description , @RequestHeader("vars") List<String> vars);
	
	@PutMapping("/Update")
	public ResponseEntity<?> updateTemplate();
	
	
}
