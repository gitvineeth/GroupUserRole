package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroupDto;
import com.example.demo.model.Group;
import com.example.demo.response.GroupResonse;
import com.example.demo.service.GroupService;

@RestController
@RequestMapping("/bo")
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	
	@PostMapping
	public String sayHello()
	{ 
		System.out.println("endpoint hit");
		return "Hello";
		
	}
	
	@PostMapping("/auth/userGroups")
	public GroupResonse addGroup(@RequestBody Group group)
	{
		System.out.println("endpoint hit");
		ModelMapper model = new ModelMapper();
		GroupDto groupDto = model.map(group,GroupDto.class);
		GroupDto fromService = groupService.createGroup(groupDto);
		GroupResonse returnValue = model.map(fromService,GroupResonse.class);
		return returnValue;
		
	}
	
	

}
