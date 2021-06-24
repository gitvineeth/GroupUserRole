package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GroupEntity {

	@Id
	@GeneratedValue
	private int id;
	private String groupId;
	private String groupCode;
	private String[] roles;
	private String groupDescription;

	public GroupEntity(int id, String groupId, String groupCode, String[] roles, String groupDescription) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupCode = groupCode;
		this.roles = roles;
		this.groupDescription = groupDescription;
	}

	public GroupEntity() {
		super();
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

}
