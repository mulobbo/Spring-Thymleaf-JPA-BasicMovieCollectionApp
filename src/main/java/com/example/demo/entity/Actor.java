package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
    
    private String role;
    
    
    public Integer getId() {
  		return id;
  	}

  	public void setId(Integer id) {
  		this.id = id;
  	}

  	public String getName() {
  		return name;
  	}

  	public void setName(String name) {
  		this.name = name;
  	}

  	public String getRole() {
  		return role;
  	}

  	public void setRole(String role) {
  		this.role = role;
  	}

}
