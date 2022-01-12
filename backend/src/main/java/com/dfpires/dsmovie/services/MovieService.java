package com.dfpires.dsmovie.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dfpires.dsmovie.dtos.MovieDTO;
import com.dfpires.dsmovie.entities.Movie;
import com.dfpires.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageabale){
		Page<Movie> movies = movieRepository.findAll(pageabale);
		Page<MovieDTO> moviePages = movies.map(x -> new MovieDTO(x));
		return moviePages;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		Movie movie = movieRepository.findById(id).get();
		MovieDTO movieDTO = new MovieDTO(movie);
		return movieDTO;
	}
	
}
