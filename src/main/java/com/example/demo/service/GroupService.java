package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GroupDto;


public interface GroupService {
	
	public GroupDto createGroup(GroupDto groupDto);

}
