package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.example.demo.dto.GroupDto;
import com.example.demo.entity.GroupEntity;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.RolesRepository;
import com.example.demo.response.GroupResonse;
import com.example.demo.service.GroupService;
import com.example.demo.shared.Utils;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	Utils utils;

	@Autowired
	RolesRepository rolesrepository;

	@Override
	public GroupDto createGroup(GroupDto groupDto) {

		ModelMapper mapper = new ModelMapper();
		GroupEntity groupEntity = mapper.map(groupDto, GroupEntity.class);
		if (groupRepository.findByGroupCode(groupEntity.getGroupCode()) != null)
			throw new RuntimeException("Group Code already exists");
		String[] str = groupDto.getRoles();
		for (int i = 0; i < groupDto.getRoles().length; i++) {

			String role = str[i];
			if (rolesrepository.findByRoleName(role) == null)
				throw new RuntimeException("Invalid group name");

		}
		groupEntity.setGroupId(utils.generateUserId(10));

		GroupEntity fromRepo = groupRepository.save(groupEntity);
		GroupDto backToController = mapper.map(fromRepo, GroupDto.class);
		return backToController;

	}

	@Override
	public List<GroupDto> findAll() {

		ModelMapper mapper = new ModelMapper();
		List<GroupEntity> groupList = groupRepository.findAll();
		if (CollectionUtils.isEmpty(groupList))
			throw new RuntimeException("Empty Group List");
		List<GroupDto> groupListToController = Arrays.asList(mapper.map(groupList, GroupDto[].class));
		return groupListToController;
	}

	@Override
	public GroupDto updateGroup(GroupDto groupDto) {

		Optional<GroupEntity> group = groupRepository.findByGroupId(groupDto.getGroupId());
		if (!group.isPresent())
			throw new RuntimeException("No such group exists");
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
		if (!user.isPresent()) {
			throw new RuntimeException("No such Group exists");
		}
		GroupEntity deletedUser = user.get();
		groupRepository.delete(deletedUser);

	}

}
