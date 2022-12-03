package com.confety.mail.controller.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.confety.mail.controller.SendMessageController;
import com.confety.mail.dto.SendRequest;
import com.confety.mail.service.SendMessageService;

@RestController
@RequestMapping("Send")
public class SendMessageControllerImplement implements SendMessageController {
	
	@Autowired
	private SendMessageService sendMessageService;
	
	@Override
	public ResponseEntity<?> sendMessage(SendRequest sendRequest) {	
		return sendMessageService.sendMessage(sendRequest);
	}

}
