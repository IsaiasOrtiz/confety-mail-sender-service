package com.confety.mail.service;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.confety.mail.dto.Body;
import com.confety.mail.entity.Templates;
import com.confety.mail.repository.TemplateRepository;


@Service
public class TemplateService {

	final Logger LOG = Logger.getLogger("com.confety.mail.service.TemplateService.class");
	
	private static final String CONTENT_TYPE = "text/html";
	
	@Autowired
	private TemplateRepository templateRepository;
	
	public ResponseEntity<?> saveNewTemplate(MultipartFile templateFile, String title, String description,
			List<String> vars){
		try {
			if(validateContentType(templateFile)) {
				Templates template = new Templates();
				template.setContent(new String(templateFile.getBytes()));
				template.setDescription(description);
				template.setName(title);
				template.setVars(vars.toString());
				templateRepository.save(template);	
				return new ResponseEntity<Body>(new Body("La template fue creada exitosamente con Id --> " + template.getId()) , HttpStatus.OK);
			}else {
				return new ResponseEntity<Body>(new Body("Error al procesar el archivo, solo se admiten html con contenido.") , HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (IOException e) {
			return new ResponseEntity<Body>(new Body(e.getMessage()) , HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	private Boolean validateContentType(MultipartFile templateFile) throws IOException {
		if(templateFile != null && CONTENT_TYPE.equals(templateFile.getContentType()) && templateFile.getSize() > 0) {
			LOG.info("Template cumple con los requisitos para ser procesada.");
			return true;
		}
		LOG.warning("Error al procesar el archivo.");
		return false;
	}
	
	
}
