package com.dfpires.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfpires.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
}
