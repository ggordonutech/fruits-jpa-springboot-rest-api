package jm.edu.utech.fruitbasketmone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jm.edu.utech.fruitbasketmone.repositories.IBasketRepository;
import jm.edu.utech.fruitbasketmone.entities.Basket;
import jm.edu.utech.fruitbasketmone.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {
	
	@Autowired
	private IBasketRepository repo;
	
	@GetMapping("")
	public List<Basket> getAll() {
		return repo.findAll(); 
	}
	
	@PostMapping("")
	public Basket create(@Valid @RequestBody Basket data) {
		return repo.save(data);
	}
	
	@GetMapping("/{id}")
	public Basket get(@PathVariable(value="id")  int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket","id",id));
	}
	
	// Update a Note
	@PutMapping("/{id}")
	public Basket update(@PathVariable(value = "id") int id,
	                                        @Valid @RequestBody Basket details) {

	    Basket basket = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Basket", "id", id));

	    basket.setOwnerName(details.getOwnerName());

	    basket = repo.save(basket);
	    return basket;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
		Basket basket = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Basket", "id", id));

	    repo.delete(basket);

	    return ResponseEntity.ok().build();
	}


}
