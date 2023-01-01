package com.masai.app.service;

import org.springframework.stereotype.Service;

import com.masai.app.entity.User;

@Service
public interface UserService {
	public User addUser(User user);
	public User getUser(int id);
}
