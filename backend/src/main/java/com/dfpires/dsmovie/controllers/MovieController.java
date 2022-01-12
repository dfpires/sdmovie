package com.dfpires.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfpires.dsmovie.dtos.MovieDTO;
import com.dfpires.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable){
		
		return movieService.findAll(pageable);
	
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO find(@PathVariable Long id){
		
		return movieService.findById(id);
	
	}
}
