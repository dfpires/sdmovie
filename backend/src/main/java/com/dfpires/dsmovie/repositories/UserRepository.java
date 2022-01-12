package com.dfpires.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfpires.dsmovie.entities.Movie;
import com.dfpires.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
