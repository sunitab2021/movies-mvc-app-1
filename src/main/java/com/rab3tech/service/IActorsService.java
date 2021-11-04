package com.rab3tech.service;

import java.util.List;

import com.rab3tech.controller.dto.ActorDTO;

public interface IActorsService {

	void save(ActorDTO actorDTO);

	List<ActorDTO> findActors(int mid);

}
