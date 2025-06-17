package com.global.book.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Document(collection  = "authors")
public class Author {

	// the main issue you had is here, Id is not the same as id, it wasn't mapped to your db properly
	@MongoId
	private String id;
	@NotEmpty
	private String name;
	@Email
	private String email;
	private String phone;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
