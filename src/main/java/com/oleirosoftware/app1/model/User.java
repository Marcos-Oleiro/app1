package com.oleirosoftware.app1.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	private String name;
	private String passwd;
	private Roles  role;
	
	public User(String name, String passwd, Roles role) {
		super();
		this.name = name;
		this.passwd = passwd;
		this.role = role;
	}
	
	
}
