package com.springboot.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.RoleEntity;
import com.springboot.service.IRoleExample;

@Service
public class RoleExample implements IRoleExample{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public RoleEntity findOne(long id) {
		String sql = "select r from RoleEntity r";
		Query query = entityManager.createQuery(sql);
		RoleEntity role =  (RoleEntity) query.getResultList().get(0);
		return  role;
	}
	
}
