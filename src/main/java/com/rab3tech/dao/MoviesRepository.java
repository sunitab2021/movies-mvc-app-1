package com.rab3tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.MovieEntity;

public interface MoviesRepository extends JpaRepository<MovieEntity, Integer>{

}
