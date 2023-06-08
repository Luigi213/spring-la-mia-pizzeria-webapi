package org.java.project.api.controller;

import java.util.List;
import java.util.Optional;

import org.java.project.api.controller.dto.PizzaResponseDto;
import org.java.project.pojo.Pizza;
import org.java.project.serv.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PizzaApiController {
	
	@Autowired
	private ServicePizza servicePizza;
	
	@GetMapping("/pizzas")
	public ResponseEntity<List<Pizza>> getPizzas(
			@RequestParam(required = false) String name
			) {
		
		List<Pizza> pizzas = servicePizza.findAll();

		if(name == null) {
			return new ResponseEntity<>(pizzas, HttpStatus.OK);
		} else if(!name.isEmpty()) {			
			List<Pizza> pizzasName = servicePizza.findByName(name);
			return new ResponseEntity<>(pizzasName, HttpStatus.OK);
		}
	
		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}
	
	@GetMapping("/pizzas/{id}")
	public ResponseEntity<Pizza> getPizzaShow(
			@PathVariable int id
			){
		Pizza pizza = servicePizza.findById(id).get();
		
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@PutMapping("/pizzas")
	public ResponseEntity<PizzaResponseDto> createBook(
			@RequestBody Pizza pizza
		) {
		
		pizza = servicePizza.save(pizza);
		
		return new ResponseEntity<>(
				new PizzaResponseDto(pizza), 
				HttpStatus.OK);	
	}

	
	@PostMapping("/pizzas")
	public ResponseEntity<PizzaResponseDto> storePizza(
			@RequestBody Pizza pizza
			){

		pizza = servicePizza.save(pizza);
		
		return new ResponseEntity<>(
				new PizzaResponseDto(pizza), 
				HttpStatus.OK);	
	}
	
	@DeleteMapping("/pizzas/{id}")
	public ResponseEntity<PizzaResponseDto> deletePizza(
			@PathVariable Integer id
		) {

		Optional<Pizza> optPizza = servicePizza.findById(id);
		
		if (optPizza.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);	
		}
		Pizza pizza = optPizza.get();
		
		pizza.getIngredientes().clear();
		servicePizza.save(pizza);
		servicePizza.delete(pizza);
		
		return new ResponseEntity<>(
				new PizzaResponseDto(pizza), 
				HttpStatus.OK);	
	}
}