package com.cts.projectmanagerfsdapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagerfsdapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
