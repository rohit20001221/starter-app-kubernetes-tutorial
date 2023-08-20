package com.lazyprogrammer.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazyprogrammer.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
