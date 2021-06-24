package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RolesEntity {
	@Id
	int id;
	String roleName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRollName() {
		return roleName;
	}
	public void setRollName(String rollName) {
		this.roleName = rollName;
	}
	
	
	

}
