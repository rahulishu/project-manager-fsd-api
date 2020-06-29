package com.cts.projectmanagerfsdapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagerfsdapi.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
