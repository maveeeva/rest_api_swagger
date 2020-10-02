package com.example.person;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class PersonResource {

	@Autowired
	private PersonDaoImpl personDaoImpl;

	@GetMapping("/persons")
	public List<Person> retrieveAllPersons() {
		return personDaoImpl.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person retrievePerson(@PathVariable int id) {
		Person person = personDaoImpl.findOne(id);
		
		if(person == null ) {
			throw new PersonNotFoundException("id-"+id);
		}
		// "all-users , server path +"/persons"
		//retrieveAllPersons
//		Resource<Person> resource = new Resource();
	//	ControllerLinkBuilder
		return person;
	}
	// HATEOAS hyper media as the engine of application state
	
	@PostMapping("/persons")
	public ResponseEntity<?> createPerson(@Valid @RequestBody Person person) {
		Person savedPerson = personDaoImpl.save(person);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").
				buildAndExpand(savedPerson.getId())
				.toUri();
		return ResponseEntity.created(location).build() ;
		
	}
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable int id) {
		Person person = personDaoImpl.deleteById(id);
		if(person == null ) {
			throw new PersonNotFoundException("id-"+id);
		}
		
	}
}
