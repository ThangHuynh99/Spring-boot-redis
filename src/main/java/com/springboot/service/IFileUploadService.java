package com.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.dto.ImageDTO;

public interface IFileUploadService {
	
	 void uploadLocal(MultipartFile file);
	 ImageDTO uploadDB(MultipartFile file);
	 ImageDTO downloadFile(Long id);
}
