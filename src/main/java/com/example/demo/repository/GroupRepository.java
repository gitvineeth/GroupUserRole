package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity,Integer> {

}
