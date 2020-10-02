package com.example.person;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="pesrson deatils")
@Entity
public class Person {
	
	//create table person (id integer not null, birthdate timestamp, name varchar(255), primary key (id))
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "person")
	private List<Post> posts;
	
	@Size(min = 2, message ="Name should be atleast 2 character")
	@ApiModelProperty(notes="Name should be atleast 2 character" )
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthdate can not be in future")
	private Date birthdate;
	
	protected Person() {
		
	}
	public Person(Integer id, String name, Date birthdate) {
		super();
		this.id = id;		
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public Integer getId() {
		return id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +", birthdate=" + birthdate +  "]";
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

}
