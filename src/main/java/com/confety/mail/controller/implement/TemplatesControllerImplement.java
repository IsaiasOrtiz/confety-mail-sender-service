package com.confety.mail.controller.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.confety.mail.controller.TemplatesController;
import com.confety.mail.service.TemplateService;

@RestController
@RequestMapping("Templates")
public class TemplatesControllerImplement implements TemplatesController {

	@Autowired
	private TemplateService templateService;

	@Override
	public ResponseEntity<?> updateTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> saveNewTemplate(MultipartFile templateFile, String title, String description,
			List<String> vars) {
		return templateService.saveNewTemplate(templateFile, title, description, vars);
	}

}
