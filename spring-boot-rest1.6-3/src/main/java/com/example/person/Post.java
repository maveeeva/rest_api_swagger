package com.example.person;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.engine.profile.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	private String decripton ;
	@ManyToOne(fetch= FetchType.LAZY)
	@JsonIgnore
	private Person person;
	
	
	public Integer getId() {
		return id;
	}
	public String getDecripton() {
		return decripton;
	}
	public Person getPerson() {
		return person;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDecripton(String decripton) {
		this.decripton = decripton;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", decripton=" + decripton +  "]";
	}

}
