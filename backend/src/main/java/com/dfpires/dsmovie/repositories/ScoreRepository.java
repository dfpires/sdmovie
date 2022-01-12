package com.dfpires.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfpires.dsmovie.entities.Movie;
import com.dfpires.dsmovie.entities.Score;
import com.dfpires.dsmovie.entities.ScorePK;
import com.dfpires.dsmovie.entities.User;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
}
