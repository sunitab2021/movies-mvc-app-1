package com.rab3tech.service;

import java.util.List;

import com.rab3tech.controller.dto.MovieDTO;

public interface IMoviesService {

	String save(MovieDTO movieDTO);

	MovieDTO findByMid(int mid);

	void updateByMid(MovieDTO movieDTO);

	List<MovieDTO> findAll();

	void deleteByMid(int mid);

}
