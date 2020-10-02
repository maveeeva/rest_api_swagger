package com.example.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PersonDaoImpl {
	private static List<Person> persons = new ArrayList<>();
	private static int userCount =3;
	static {
		persons.add(new Person(1,"Adam", new Date()));
		persons.add(new Person(2,"Eva", new Date()));
		persons.add(new Person(3,"Deep", new Date()));
	}

	public List<Person> findAll() {
		return persons;
	}
	
	public Person save(Person person) {
		if(person.getId() == null) {
			person.setId(++userCount);
			
		}
		persons.add(person);
		return person;
	}
	
	public Person findOne(int id) {
		for(Person person :persons) {
			if(person.getId() ==id) {
				return person;
			}
		}
		return null;
	}
	public Person deleteById(int id) {
		if (!persons.isEmpty()) {
		Iterator<Person> it = persons.iterator();
		
		while(it.hasNext()) {
			Person per = it.next(); 
			if(per.getId() ==id) {
				it.remove();
				return per;
			}
		}
	}
		return null;
	}
}
