package com.rab3tech.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.controller.dto.MovieDTO;
import com.rab3tech.dao.MoviesRepository;
import com.rab3tech.dao.ProducerRepository;
import com.rab3tech.dao.entity.MovieEntity;
import com.rab3tech.dao.entity.ProducerEntity;

@Service
public class MoviesService implements IMoviesService{
	
	
	/*
	 * @Autowired private IMoviesDao iMoviesDao;
	 */
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private ProducerRepository producerRepository;
	
	@Override
	public String save(MovieDTO movieDTO) {
		MovieEntity movieEntity=new MovieEntity();
		BeanUtils.copyProperties(movieDTO, movieEntity);
		movieEntity.setYear(new Date());
		
		ProducerEntity producerEntity=new ProducerEntity();
		producerEntity.setAddress("Fremont, USA");
		producerEntity.setCreatedate(new Timestamp(new Date().getTime()));
		producerEntity.setEmail("technohunk444@gmail.com");
		producerEntity.setMobile("98726262562");
		producerEntity.setName("Nagendra Kumar");
		producerEntity.setMovieEntity(movieEntity);
		
		producerRepository.save(producerEntity);
		return "success";
	}
	
	
	@Override
	public MovieDTO findByMid(int mid){
		MovieEntity movieEntity=moviesRepository.findById(mid).get();
		MovieDTO movieDTO=new MovieDTO();
		BeanUtils.copyProperties(movieEntity, movieDTO);
		movieDTO.setMdate(movieEntity.getYear());
		return movieDTO;
	}
	
	@Override
	public void updateByMid(MovieDTO movieDTO) {
		MovieEntity entity=new MovieEntity();
		BeanUtils.copyProperties(movieDTO, entity);
		moviesRepository.save(entity);
	}
	
	@Override
	public List<MovieDTO>  findAll(){
		List<MovieDTO> movieDTOs=new ArrayList<>();
		List<MovieEntity> movieEntities=moviesRepository.findAll();
		for(MovieEntity entity:movieEntities) {
			MovieDTO movieDTO=new MovieDTO();
			BeanUtils.copyProperties(entity, movieDTO);
			movieDTO.setMdate(entity.getYear());
			movieDTOs.add(movieDTO);
		}
	    return movieDTOs;
	}
	
	@Override
	public void  deleteByMid(int mid) {
		moviesRepository.deleteById(mid);
	}

}
