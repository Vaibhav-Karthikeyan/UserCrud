package com.masai.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Email;
import com.masai.app.entity.User;
import com.masai.app.repository.EmailRepository;
import com.masai.app.repository.UserRepository;


@Service
public class UserImpl implements UserService {

	@Autowired
	UserRepository rep;
	
	@Autowired
	EmailRepository em;
	
	public User addUser(User user){
		rep.save(user);
		return user;
	}
	
	public User getUser(int id) {
		return rep.findById(id).get();
	}
	
	public List<User> getAllUsers() {
		return rep.findAll();
	}
	
	public User createMail(int id,Email email){
		User u=rep.findById(id).get();
		u.setEmail(email);
		em.save(email);
		return u;
	}
	
	public List<User> deleteUser(int id) {
		rep.deleteById(id);
		return getAllUsers();
	}
	
	public Email findEmail(int id,int mailId){
		return rep.findEmail(id, mailId);
	}
}
