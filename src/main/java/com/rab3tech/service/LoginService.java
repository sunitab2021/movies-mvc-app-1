package com.rab3tech.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.dao.LoginRepository;
import com.rab3tech.dao.RolesRepository;
import com.rab3tech.dao.entity.LoginEntity;
import com.rab3tech.dao.entity.RolesEntity;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	@Transactional
	public void save(String username,String password) {
		
		Random random = new Random();
		int role1 = random.nextInt(4);
		if (role1 == 0) {
			role1 = 1;
		}
		int role2 = random.nextInt(4);
		if (role2 == 0) {
			role2 = 2;
		}
		
		RolesEntity rolesEntity1=rolesRepository.findById(role1).get();
		RolesEntity rolesEntity2=rolesRepository.findById(role2).get();
		Set<RolesEntity> roles=new HashSet<>();
		roles.add(rolesEntity1);
		roles.add(rolesEntity2);
		
		LoginEntity entity=new LoginEntity();
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setRoles(roles);
		loginRepository.save(entity);
	}

}
