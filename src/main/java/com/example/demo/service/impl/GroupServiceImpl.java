package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.example.demo.dto.GroupDto;
import com.example.demo.entity.GroupEntity;
import com.example.demo.repository.GroupRepository;
import com.example.demo.response.GroupResonse;
import com.example.demo.service.GroupService;
import com.example.demo.shared.Utils;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	Utils utils;

	@Override
	public GroupDto createGroup(GroupDto groupDto) {

		ModelMapper mapper = new ModelMapper();
		GroupEntity groupEntity = mapper.map(groupDto, GroupEntity.class);
		groupEntity.setGroupId(utils.generateUserId(10));
		GroupEntity fromRepo = groupRepository.save(groupEntity);
		GroupDto backToController = mapper.map(fromRepo, GroupDto.class);
		return backToController;

	}

	@Override
	public List<GroupDto> findAll() {

		ModelMapper mapper = new ModelMapper();
		List<GroupEntity> groupList = groupRepository.findAll();
		List<GroupDto> groupListToController = Arrays.asList(mapper.map(groupList, GroupDto[].class));
		return groupListToController;
	}

	@Override
	public GroupDto updateGroup(GroupDto groupDto) {
        
		Optional<GroupEntity> group = groupRepository.findByGroupId(groupDto.getGroupId());
		GroupEntity entity = group.get();
		entity.setGroupCode(groupDto.getGroupCode());
		entity.setRoles(groupDto.getRoles());
		entity.setGroupDescription(groupDto.getGroupDescription());
	    GroupEntity updatedUser = groupRepository.save(entity);
		ModelMapper mapper = new ModelMapper();
		GroupDto updatedUserToController = mapper.map(updatedUser, GroupDto.class);
		return updatedUserToController;
		
	}

	@Override
	public void deleteUserById(String id) {
		
		Optional<GroupEntity> user = groupRepository.findByGroupId(id);
		GroupEntity deletedUser = user.get();
		groupRepository.delete(deletedUser);
		
	}

}
