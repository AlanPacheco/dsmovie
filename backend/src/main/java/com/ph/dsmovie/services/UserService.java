package com.ph.dsmovie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ph.dsmovie.entities.User;
import com.ph.dsmovie.entities.dto.UserDTO;
import com.ph.dsmovie.entities.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable){
		Page<User> users = repository.findAll(pageable);
		return users.map(user -> new UserDTO(user));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id){
		Optional<User> users = repository.findById(id);
		User user = users.orElseThrow(() -> new IllegalArgumentException());
		return new UserDTO(user);
	}
	
	
}
