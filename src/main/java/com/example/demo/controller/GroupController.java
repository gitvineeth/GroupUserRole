package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.mbeans.GroupMBean;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroupDto;
import com.example.demo.entity.GroupEntity;
import com.example.demo.model.Group;
import com.example.demo.response.GroupResonse;
import com.example.demo.service.GroupService;

@RestController
@RequestMapping("/bo")
public class GroupController {

	@Autowired
	GroupService groupService;

	@PostMapping("/auth/userGroups")
	public GroupResonse addGroup(@RequestBody Group group) {
		System.out.println("endpoint hit");
		ModelMapper model = new ModelMapper();
		GroupDto groupDto = model.map(group, GroupDto.class);
		GroupDto fromService = groupService.createGroup(groupDto);
		GroupResonse returnValue = model.map(fromService, GroupResonse.class);
		return returnValue;

	}

	@GetMapping("/auth/userGroups")
	public List<GroupResonse> retrieveAllGroups() {
		ModelMapper mapper = new ModelMapper();

		List<GroupDto> groupList = groupService.findAll();
		List<GroupResonse> groupListAsResponse = Arrays.asList(mapper.map(groupList, GroupResonse[].class));
		return groupListAsResponse;
	}

	@PostMapping("/auth/userGroups/modify")
	public GroupResonse UpdateGroup(@RequestBody Group group)

	{
		ModelMapper mapper = new ModelMapper();
		GroupDto groupDto = mapper.map(group, GroupDto.class);
		GroupDto updated = groupService.updateGroup(groupDto);
		GroupResonse response = mapper.map(updated, GroupResonse.class);
		return response;
	}
	@PostMapping("/auth/userGroups/delete/{id}")
	public void DeleteUser(@PathVariable("id") String id)
	{
		groupService.deleteUserById(id);
	}

}
