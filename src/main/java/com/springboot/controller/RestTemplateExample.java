package com.springboot.controller;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {
	private static final String PRODUCT_URL = "http://localhost:8080/api/product/1";
	
	   public static void main(String[] args) {
		    // HttpHeaders
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Yêu cầu trả về định dạng JSON
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	        RestTemplate restTemplate = new RestTemplate();
	        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
	        ResponseEntity<String> response = restTemplate.exchange(PRODUCT_URL, //
	                HttpMethod.GET, entity, String.class);
	 
	      //  String result = response.getBody();
	 
	        System.out.println(response.getBody());
	   }
}
