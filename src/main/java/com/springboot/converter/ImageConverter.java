package com.springboot.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.dto.ImageDTO;
import com.springboot.entity.ImageEntity;

@Component
public class ImageConverter {
	@Autowired
	private ModelMapper mapper;
	
	public ImageEntity toEntity(ImageDTO dto) {
		ImageEntity entity = mapper.map(dto, ImageEntity.class);
		return entity;
	}
	
	public ImageDTO toDTO(ImageEntity entity) {
		ImageDTO dto = mapper.map(entity, ImageDTO.class);
		return dto;
	}
}
