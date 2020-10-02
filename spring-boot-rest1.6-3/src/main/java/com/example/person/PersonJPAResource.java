package com.example.person;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class PersonJPAResource {

	
	@Autowired
	private PersonRepository personRepository;
	
	private PostRepository postRepository;

	@GetMapping("/jpa/persons")
	public List<Person> retrieveAllPersons() {
		return personRepository.findAll();
	}
	
	@GetMapping("/jpa/persons/{id}")
	public Optional<Person> retrievePerson(@PathVariable int id) {
		Optional<Person> person = personRepository.findById(id);
		
		if(!person.isPresent() ) {
			throw new PersonNotFoundException("id-"+id);
		}
		// "all-users , server path +"/persons"
		//retrieveAllPersons
//		Resource<Person> resource = new Resource(person.get());
	//	ControllerLinkBuilder
		return person;
	}
	// HATEOAS hyper media as the engine of application state
	
	@PostMapping("/jpa/persons")
	public ResponseEntity<?> createPerson(@Valid @RequestBody Person person) {
		Person savedPerson = personRepository.save(person);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").
				buildAndExpand(savedPerson.getId())
				.toUri();
		return ResponseEntity.created(location).build() ;
		
	}
	@DeleteMapping("/jpa/persons/{id}")
	public void deletePerson(@PathVariable int id) {
		 personRepository.deleteById(id);
//		if(person == null ) {
//			throw new PersonNotFoundException("id-"+id);
//		}
		
	}
	
	@GetMapping("/jpa/persons/{id}/posts")
	public List<Post> retrieveAllPersons(@PathVariable int id) {
		Optional<Person>personOptional = personRepository.findById(id);
		if(!personOptional.isPresent()) {
		throw new PersonNotFoundException("id ="+id);
		}
		
		return personOptional.get().getPosts();
	}
	
	@PostMapping("/jpa/persons{id}/posts")
	public ResponseEntity<?> createPost(@PathVariable int id, Post post) {
		Optional<Person>personOptional = personRepository.findById(id);
		if(!personOptional.isPresent()) {
		throw new PersonNotFoundException("id ="+id);
		}
		Person person = personOptional.get();
		post.setPerson(person);
		postRepository.save(post);
		//return personOptional.get().getPosts();
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").
				buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build() ;
		
	}
}
