package com.carros.car.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@PostMapping
	public void SaveCar(@RequestBody Carro carro) {
		service.insert(carro);
		
	};
	
	@PutMapping("/{id}")
	public void Update(@PathVariable("id") Long id, @RequestBody Carro carro) {
		service.update(carro, id);
		
	};
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return "Objeto deletado com sucesso!";
	};
	
	
};
