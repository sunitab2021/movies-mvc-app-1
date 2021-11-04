package com.rab3tech.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.controller.dto.ActorDTO;
import com.rab3tech.dao.ActorRepository;
import com.rab3tech.dao.MoviesRepository;
import com.rab3tech.dao.entity.ActorsEntity;
import com.rab3tech.dao.entity.MovieEntity;

@Service
public class ActorsService implements IActorsService{
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Override
	public void save(ActorDTO actorDTO) {
		
		MovieEntity movieEntity=moviesRepository.findById(actorDTO.getMid()).get();
		
		ActorsEntity actorsEntity=new ActorsEntity();
		actorsEntity.setName(actorDTO.getName());
		actorsEntity.setPhoto(actorDTO.getPhoto());
		actorsEntity.setRole(actorDTO.getRole());
		actorsEntity.setCreatedate(new Timestamp(new Date().getTime()));
		
		//setting parent entity to make relationship
		actorsEntity.setMovie(movieEntity);
		
		actorRepository.save(actorsEntity);
	}
	
	@Override
	public List<ActorDTO> findActors(int mid) {
		List<ActorDTO> list=new ArrayList<>();
		//Loading movie entity as per mid
		MovieEntity movieEntity=moviesRepository.findById(mid).get();
		List<ActorsEntity> actorList=movieEntity.getActors();
		for(ActorsEntity entity:actorList) {
			ActorDTO actorDTO=new ActorDTO();
			actorDTO.setCreatedate(entity.getCreatedate());
			actorDTO.setName(entity.getName());
			actorDTO.setRole(entity.getRole());
			actorDTO.setPhoto(entity.getPhoto());
			list.add(actorDTO);
		}
		return list;
	}
	

}
