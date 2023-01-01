package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.Email;
import com.masai.app.entity.User;
import com.masai.app.service.UserImpl;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	UserImpl u;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return u.addUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable(value = "id") int id) {
		return u.getUser(id);
	}
	
	@PostMapping("/user/{id}")
	public List<User> deleteUser(@PathVariable(value = "id") int id) {
		return u.deleteUser(id);
	}
	
	@GetMapping("/user")
	public List<User> findUser() {
		return u.getAllUsers();
	}
	
	@PostMapping("/user/{id}/mail")
	public User deleteUser(@PathVariable(value = "id") int id,@RequestBody Email email) {
		return u.createMail(id,email);
	}
	
	@GetMapping("/user/{id}/mail/{mailId}")
	public Email viewEmail(@PathVariable(value = "id") int id,@PathVariable(value = "mailId") int mailId) {
		return u.findEmail(id,mailId);
	}
}
