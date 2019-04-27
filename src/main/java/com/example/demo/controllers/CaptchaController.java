package com.example.demo.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entidades.Response;
import com.example.demo.model.managers.CaptchaManager;
import com.example.demo.model.dto.CaptchaResponseDto;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class CaptchaController {
	
	@Autowired
	CaptchaManager captchaManager;
	
	
	@PostMapping("captcha")
	public ResponseEntity<CaptchaResponseDto> captcha(
			 @RequestBody Response response,
			 HttpServletRequest request
			){
		
		CaptchaResponseDto apiResponse = captchaManager.verifyCaptcha(response.getResponse(), request.getRemoteAddr());
		
		return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
		
	}
}
