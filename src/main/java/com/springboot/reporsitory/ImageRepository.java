package com.springboot.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

}
