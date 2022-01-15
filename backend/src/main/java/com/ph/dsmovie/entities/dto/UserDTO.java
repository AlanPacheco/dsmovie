package com.ph.dsmovie.entities.dto;

import com.ph.dsmovie.entities.User;

public class UserDTO {
	private Long id;
	private String email;

	public UserDTO() {
	}

	public UserDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getEmail());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
