package com.dfpires.dsmovie.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dfpires.dsmovie.dtos.MovieDTO;
import com.dfpires.dsmovie.dtos.ScoreDTO;
import com.dfpires.dsmovie.entities.Movie;
import com.dfpires.dsmovie.entities.Score;
import com.dfpires.dsmovie.entities.User;
import com.dfpires.dsmovie.repositories.MovieRepository;
import com.dfpires.dsmovie.repositories.ScoreRepository;
import com.dfpires.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto){
		
			User user = userRepository.findByEmail(null);
			if (user == null) {
				user = new User();
				user.setEmail(dto.getEmail());
				userRepository.saveAndFlush(user);
			}
			
			Movie movie = movieRepository.findById(dto.getMovieId()).get();
			
			Score score = new Score();
			score.setMovie(movie);
			score.setUser(user);
			score.setValue(dto.getScore());
			
			score = scoreRepository.saveAndFlush(score);
			
			double sum = 0;
			for(Score x: movie.getScores()) {
				sum += x.getValue();
			}
			
			double avg = sum / movie.getScores().size();
			movie.setScore(avg);
			movie.setCount(movie.getScores().size());
			
			movie = movieRepository.save(movie);
			
			
			return new MovieDTO(movie);
		}
	
}
