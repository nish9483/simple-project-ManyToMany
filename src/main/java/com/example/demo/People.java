package com.example.demo;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class People {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String name;
	private String address;
	
	@ManyToMany
	@JoinTable(name="people_movie",
	joinColumns=@JoinColumn(name="people_id"),
	inverseJoinColumns=@JoinColumn(name="movie_id"))
	
	private Set<Movie>movie;
	
	
	People()
	{
		
	}

	public People(int id, String name, String address, Set<Movie> movie) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}
	
	
	

}
