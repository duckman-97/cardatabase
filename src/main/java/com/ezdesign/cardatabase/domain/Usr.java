package com.ezdesign.cardatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usr {
	@Id
	@GeneratedValue(generator = "CarSeq")
	@SequenceGenerator(name = "CarSeq",sequenceName = "CARDB_SEQ",allocationSize = 0)
	@Column(nullable=false , updatable=false)
	private long id;
	@Column(nullable=false , unique=true)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
	
	public Usr() {}
	public Usr(String username,String password,String role) {
		super();
		this.username = username;
		this.password = password;
		this.role=role;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
