package com.home.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.tunehub.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}
