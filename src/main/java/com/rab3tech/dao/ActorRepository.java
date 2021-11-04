package com.rab3tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.ActorsEntity;

public interface ActorRepository extends JpaRepository<ActorsEntity, Integer> {

}
