package com.carros.car.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/{id}")
	public Optional<Carro> getCarId(@PathVariable("id") Long id){
		return service.getCarFindId(id);
	};
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> getCarTipo(@PathVariable("tipo") String tipo){
		return service.getCarByTipo(tipo);
	};
	
	
};
