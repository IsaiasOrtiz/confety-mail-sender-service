package com.confety.mail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.confety.mail.dto.Body;
import com.confety.mail.dto.MetaData;
import com.confety.mail.dto.SendRequest;
import com.confety.mail.entity.Templates;
import com.confety.mail.repository.TemplateRepository;

@Service
public class SendMessageService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateRepository templateRepository;

	private static final String FROM = "Confety.Studios";

	public ResponseEntity<?> sendMessage(SendRequest sendRequest) {
		try {
			if (validarCorreo(sendRequest.getTo())) {
				String messageContent = buildMessage(sendRequest);
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper;
				helper = new MimeMessageHelper(message, true);
				helper.setFrom(FROM);
				helper.setTo(sendRequest.getTo());
				helper.setSubject(sendRequest.getSubject());
				helper.setText(messageContent, true);
				mailSender.send(message);
			}else {
				return new ResponseEntity<Body>(new Body("Correo electronico invalido!") , HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (NotAcceptableStatusException e1) {
			return new ResponseEntity<Body>(new Body(e1.getReason()) , HttpStatus.NOT_ACCEPTABLE);
		} catch (MessagingException e) {
			return new ResponseEntity<Body>(new Body(e.getMessage() ), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Body>(new Body("Enviado exitosamente!"), HttpStatus.CREATED);
	}

	private String buildMessage(SendRequest sendRequest) {
		try {
			Optional<Templates> template = templateRepository.findById(sendRequest.getTemplate());

			if (template.isPresent()) {
				List<String> keys = new ArrayList<>();	
				String finalMessage = template.get().getContent();
				for (MetaData meta : sendRequest.getMetaData()) {
					if(template.get().getVars().contains(meta.getKey())) {
						finalMessage = finalMessage.replace("$[{" + meta.getKey() + "}]", meta.getValue());
					}else {
						throw new NotAcceptableStatusException("MetaData incompleta debe contener -> "+ template.get().getVars());
					}
				}
				
				return finalMessage;
			} else {
				throw new NotAcceptableStatusException("Template con Id "+ sendRequest.getTemplate() + " no existe.");
			}
		}catch(NotAcceptableStatusException no) {
			throw no;
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Boolean validarCorreo(String email) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}
}
