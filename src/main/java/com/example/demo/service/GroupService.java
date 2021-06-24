package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GroupDto;
import com.example.demo.entity.GroupEntity;


public interface GroupService {
	
	public GroupDto createGroup(GroupDto groupDto);
	public List<GroupDto> findAll();
	public GroupDto updateGroup(GroupDto groupDto);
	public void deleteUserById(String id);

}
