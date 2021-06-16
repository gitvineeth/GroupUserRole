package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.GroupDto;
import com.example.demo.entity.GroupEntity;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	@Override
	public GroupDto createGroup(GroupDto groupDto) {
		
		
		  ModelMapper mapper = new ModelMapper();
		  GroupEntity groupEntity = mapper.map(groupDto, GroupEntity.class);
		  groupEntity.setGroupId("1234ABFG");
		  GroupEntity fromRepo = groupRepository.save(groupEntity);
		  GroupDto backToController = mapper.map(fromRepo, GroupDto.class);
		  return backToController;
		
	}

}
