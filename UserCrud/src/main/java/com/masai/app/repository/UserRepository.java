package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.app.entity.Email;
import com.masai.app.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("Select email from User where id=?1 and email.email_id=?2")
	public Email findEmail(int id,int mailId);
}
