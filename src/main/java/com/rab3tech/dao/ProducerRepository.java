package com.rab3tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.ProducerEntity;

public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer> {

}
