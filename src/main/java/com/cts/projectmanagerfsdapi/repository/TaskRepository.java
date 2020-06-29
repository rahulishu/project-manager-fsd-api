package com.cts.projectmanagerfsdapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagerfsdapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
