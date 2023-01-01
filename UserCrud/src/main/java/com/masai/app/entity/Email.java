package com.masai.app.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Email {
	
	@Id
	@GeneratedValue
	private int email_id;
	private String email;
	private Date created_date;
	
	@OneToOne(mappedBy="email")
	private User user;
	
	public Email(){
		
	}

	public Email(int email_id, String email, Date created_date, User user) {
		super();
		this.email_id = email_id;
		this.email = email;
		this.created_date = created_date;
		this.user = user;
	}

	public int getEmail_id() {
		return email_id;
	}

	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_date, email, email_id, user);
	}

	@Override
	public String toString() {
		return "Email [email_id=" + email_id + ", email=" + email + ", created_date=" + created_date + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(created_date, other.created_date) && Objects.equals(email, other.email)
				&& email_id == other.email_id && Objects.equals(user, other.user);
	}
	
	
}
