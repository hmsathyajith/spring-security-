package com.sathyajith;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathyajith.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findUserByUserName(String userName);
}
