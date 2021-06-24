package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.AppConstants;
import com.example.demo.dto.GroupDto;
import com.example.demo.model.Group;
import com.example.demo.response.GroupResonse;
import com.example.demo.service.GroupService;

@RestController
@RequestMapping("/bo")
public class GroupController {

	@Autowired
	GroupService groupService;

	@PostMapping("/auth/userGroups")
	public GroupResonse addGroup(@RequestHeader(value = "ADMIN_USER_ID") final String loginId,
			@RequestBody Group group) {
		if (!AppConstants.HEADER_VALUE.equals(loginId)) {
			throw new RuntimeException("Wrong header value");
		}
		ModelMapper model = new ModelMapper();
		GroupDto groupDto = model.map(group, GroupDto.class);
		GroupDto fromService = groupService.createGroup(groupDto);
		GroupResonse returnValue = model.map(fromService, GroupResonse.class);
		return returnValue;

	}

	@GetMapping("/auth/userGroups")
	public List<GroupResonse> retrieveAllGroups(@RequestHeader(value = "ADMIN_USER_ID") final String loginId) {
		if (!AppConstants.HEADER_VALUE.equals(loginId)) {
			throw new RuntimeException("Wrong header value");
		}
		ModelMapper mapper = new ModelMapper();
		List<GroupDto> groupList = groupService.findAll();
		if (org.springframework.util.CollectionUtils.isEmpty(groupList)) {
			throw new RuntimeException("No records are available");
		}
		List<GroupResonse> groupListAsResponse = Arrays.asList(mapper.map(groupList, GroupResonse[].class));
		return groupListAsResponse;
	}

	@PostMapping("/auth/userGroups/modify")
	public GroupResonse UpdateGroup(@RequestHeader(value = "ADMIN_USER_ID") final String loginId, @RequestBody Group group) {
		if (!AppConstants.HEADER_VALUE.equals(loginId)) {
			throw new RuntimeException("Wrong header value");
		}
		ModelMapper mapper = new ModelMapper();
		GroupDto groupDto = mapper.map(group, GroupDto.class);
		GroupDto updated = groupService.updateGroup(groupDto);
		GroupResonse response = mapper.map(updated, GroupResonse.class);
		return response;
	}

	@PostMapping("/auth/userGroups/delete/{id}")
	public void DeleteUser(@RequestHeader(value = "ADMIN_USER_ID") final String loginId, @PathVariable("id") String id) {
		if (!AppConstants.HEADER_VALUE.equals(loginId)) {
			throw new RuntimeException("Wrong header value");
		}
		groupService.deleteUserById(id);
	}

}
