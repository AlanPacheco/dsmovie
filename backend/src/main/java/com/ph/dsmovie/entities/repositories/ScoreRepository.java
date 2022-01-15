package com.ph.dsmovie.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ph.dsmovie.entities.Score;
import com.ph.dsmovie.entities.ScorePK;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
}
