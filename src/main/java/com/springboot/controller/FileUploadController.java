package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.dto.ImageDTO;
import com.springboot.service.IFileUploadService;

@RestController
@RequestMapping("api")
public class FileUploadController {
	
	@Autowired
	private IFileUploadService fileUploadService;
	
	@PostMapping("file")
	public void uploadLocal(@RequestParam("image") MultipartFile file) {
		fileUploadService.uploadLocal(file);
	}
	
	@PostMapping("file/db")
	public void uploadDB(@RequestParam("image") MultipartFile file) {
		fileUploadService.uploadDB(file);
	}
	
	@GetMapping("file/{id}")
	public ImageDTO downloadFile(@PathVariable("id") Long id) {
		return fileUploadService.downloadFile(id);
	}
}
