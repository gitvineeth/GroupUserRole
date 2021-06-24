package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {

	public Optional<GroupEntity> findByGroupId(String string);

	public GroupEntity findByGroupCode(String groupCode);

}
