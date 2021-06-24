package com.example.demo.dto;

public class GroupDto {
	private String groupId;
	private String groupCode;
	private String[] roles;
	private String groupDescription;
	
	
	public GroupDto() {
		super();
	}
	
	public GroupDto(String groupId, String groupCode, String[] roles, String groupDescription) {
		super();
		this.groupId = groupId;
		this.groupCode = groupCode;
		this.roles = roles;
		this.groupDescription = groupDescription;
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

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}


	
	
}
