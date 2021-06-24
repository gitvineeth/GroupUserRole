package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.RolesEntity;

public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {

	public RolesEntity findByRoleName(String rollName);

}
