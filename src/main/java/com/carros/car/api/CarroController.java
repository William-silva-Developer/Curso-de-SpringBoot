package com.carros.car.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.car.damain.Carro;
import com.carros.car.damain.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
	
	@Autowired
	private CarroService service;
	
	@GetMapping()
	public Iterable<Carro> getCar(){
		return service.getCarros();
	};

};
