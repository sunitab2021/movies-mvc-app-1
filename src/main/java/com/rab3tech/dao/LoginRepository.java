package com.rab3tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.ActorsEntity;
import com.rab3tech.dao.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

}
