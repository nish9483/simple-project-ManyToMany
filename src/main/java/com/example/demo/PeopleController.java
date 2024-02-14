package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

	@Autowired
	private PeopleRepo pr;
	
	
	
	/*@PostMapping("/people")
	public  ResponseEntity<People>savePeople(@RequestBody People people)
	{
		People p=pr.save(people);
		return new ResponseEntity<People>(p,HttpStatus.CREATED);
	}*/
	
	@GetMapping("/people")
	public List<People>getPageOne()
	{
		Pageable pa=PageRequest.of(0, 4,Sort.by("id").ascending());
		Page<People>g=pr.findAll(pa);
		return g.getContent();
	}
	/*
	@PutMapping("/people/{id}")
	public  ResponseEntity<People>updatePeople(@RequestBody People people,@PathVariable int id)
	{
		Optional<People>e=pr.findById(id);
		if(e.isPresent())
		{
			People r=e.get();
			r.setName(people.getName());
			People t=pr.save(r);
			return new ResponseEntity<People>(t,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<People>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/people/{id}")
	public  ResponseEntity<Void>deletePeople(@PathVariable int id)
	{
		Optional<People>e=pr.findById(id);
		if(e.isPresent())
		{
	pr.deleteById(id);
	return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		}*/
	
}
