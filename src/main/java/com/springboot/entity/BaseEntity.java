package com.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@SuppressWarnings("unused")
public class BaseEntity {
	//UUID tự tạo ra một chuỗi 36 ký tự ngẫu nhiên, vd private UUID id;
	@Id //notnull va primary 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // set autoincrement
	private Long id;
	
	@Column (name = "createddate")
	@CreatedDate
	private Date createdDate;
	
	@Column (name = "modifieddate")
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column (name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column (name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
