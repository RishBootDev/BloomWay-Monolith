package com.rishbootdev.bloomway.repository;

import com.rishbootdev.bloomway.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long> {

    List<ProjectMember> findByIdProjectId(Long projectId);
}
