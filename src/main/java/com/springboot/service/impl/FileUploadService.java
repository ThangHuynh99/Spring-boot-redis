package com.springboot.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.converter.ImageConverter;
import com.springboot.dto.ImageDTO;
import com.springboot.entity.ImageEntity;
import com.springboot.reporsitory.ImageRepository;
import com.springboot.reporsitory.UserRepository;
import com.springboot.service.IFileUploadService;

@Service
public class FileUploadService implements IFileUploadService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ImageConverter imageConverter;
	private String uploadFolderPath = "C:/Users/Thang Huynh/desktop/uploaded_";

	@Override
	public void uploadLocal(MultipartFile file) {
		try {
			byte[] data = file.getBytes();
			Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
			Files.write(path, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ImageDTO uploadDB(MultipartFile file) {
		ImageDTO image = new ImageDTO();
		try {
			image.setFileData(file.getBytes());
			image.setFileName(file.getOriginalFilename());
			image.setFileType(file.getContentType());
			ImageEntity imageEntity = imageConverter.toEntity(image);
			imageEntity.setUser(userRepository.getOne((long)1));
			image = imageConverter.toDTO(imageRepository.save(imageEntity));
			return image;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ImageDTO downloadFile(Long id) {	
		return imageConverter.toDTO(imageRepository.getOne(id));
	}
	
	
}
