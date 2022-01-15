package com.ph.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ph.dsmovie.entities.Movie;
import com.ph.dsmovie.entities.Score;
import com.ph.dsmovie.entities.User;
import com.ph.dsmovie.entities.dto.MovieDTO;
import com.ph.dsmovie.entities.dto.ScoreDTO;
import com.ph.dsmovie.entities.repositories.MovieRepository;
import com.ph.dsmovie.entities.repositories.ScoreRepository;
import com.ph.dsmovie.entities.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = userRepository.saveAndFlush(new User(null,dto.getEmail()));
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()){
			sum += s.getValue();
		}
		
		movie.setScore(sum/movie.getScores().size());
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}
}
