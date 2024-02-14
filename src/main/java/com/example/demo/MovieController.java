package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class MovieController {
	
	@Autowired
	private MovieRepo mr;
	
	
	
	/*@PostMapping("/movie")
	public  ResponseEntity<Movie>savePeople(@RequestBody Movie movie)
	{
		Movie p=mr.save(movie);
		return new ResponseEntity<Movie>(p,HttpStatus.CREATED);
	}*/
	
	@GetMapping("/movie")
	public List<Movie>getPageOne()
	{
		Pageable pa=PageRequest.of(0, 4,Sort.by("id").ascending());
		Page<Movie>g=mr.findAll(pa);
		return g.getContent();
	}
	
	/*@PutMapping("/movie/{id}")
	public  ResponseEntity<Movie>updateMovie(@RequestBody Movie movie,@PathVariable int id)
	{
		Optional<Movie>e=mr.findById(id);
		if(e.isPresent())
		{
			Movie r=e.get();
			r.setMoviename(movie.getMoviename());
			r.setSeatno(movie.getSeatno());
           Movie t=mr.save(r);
			return new ResponseEntity<Movie>(t,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Movie>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/movie/{id}")
	public  ResponseEntity<Void>deletePeople(@PathVariable int id)
	{
		Optional<Movie>e=mr.findById(id);
		if(e.isPresent())
		{
	mr.deleteById(id);
	return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		}*/
	
}


