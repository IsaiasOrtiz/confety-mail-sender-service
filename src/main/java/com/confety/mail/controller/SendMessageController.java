package com.confety.mail.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.confety.mail.dto.SendRequest;

public interface SendMessageController {

	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody SendRequest sendRequest);
}
