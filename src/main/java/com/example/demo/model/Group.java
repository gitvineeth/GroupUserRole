package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

public class Group {

	@NotNull
	private String groupCode;
	@NotNull
	private String[] roles;
	@NotNull
	private String groupDescription;
	
	private String groupId;

	public Group() {
		super();
	}

	public Group(String groupCode, String[] roles, String groupDescription) {
		super();
		this.groupCode = groupCode;
		this.roles = roles;
		this.groupDescription = groupDescription;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	

}
