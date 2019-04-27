package com.example.demo.model.managers;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.dto.CaptchaResponseDto;

@Service
public class CaptchaManager {
	
	private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
	
	public CaptchaResponseDto verifyCaptcha(String response, String remoteIp) {
		
		//String secret = "6LecKKAUAAAAAFlTHesFK5rmEpZ3iKklpYmMujsZ"; //babel
		//String secret = "6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe"; //siempre
		String secret = "6LcbgaAUAAAAAIJim8IiyrClLFAVyOi-cM65Mqpk"; //mia
				
		
		RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("secret", secret);
        requestMap.add("response", response);
        requestMap.add("remoteip", remoteIp);
		
        CaptchaResponseDto apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, CaptchaResponseDto.class);

		return apiResponse;
	}

}
