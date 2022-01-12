package com.dfpires.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfpires.dsmovie.dtos.MovieDTO;
import com.dfpires.dsmovie.dtos.ScoreDTO;
import com.dfpires.dsmovie.services.MovieService;
import com.dfpires.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "scores")
public class ScoreController {

	@Autowired
	ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO score){
		MovieDTO movieDTO = scoreService.saveScore(score);
		return movieDTO;
	
	}
	

}
