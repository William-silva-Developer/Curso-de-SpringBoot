package com.carros.car.damain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.carros.car.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repCar;
	
	
	//RENDERIZAR TODOS OS CARROS NO NAVEGADOR
	public Iterable<Carro> getCarros(){
		return repCar.findAll();
	}

	
	//BUSCAR CARRO POR ID
	public Optional<Carro> getCarFindId(Long id) {	
		return repCar.findById(id); 
	}


	public Iterable<Carro> getCarByTipo(String tipo) {
		// TODO Auto-generated method stub
		return repCar.findByTipo(tipo);
	};
	
	
	
};
