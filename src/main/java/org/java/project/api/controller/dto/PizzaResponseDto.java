package org.java.project.api.controller.dto;

import org.java.project.pojo.Pizza;

public class PizzaResponseDto {
	Pizza pizza;
	
	public PizzaResponseDto(Pizza pizza) {
		setPizza(pizza);
	}

	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
}	
