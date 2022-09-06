package com.carros.car.damain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.car.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repCar;
	
	
	//RENDERIZAR TODOS OS CARROS NO NAVEGADOR
	public Iterable<Carro> getCarros(){
		return repCar.findAll();
	};
	
	
	public List<Carro> getCarrosFike(){
		
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro(1L, "Fusca" ));
		carros.add(new Carro(2L, "Chevette" ));
		carros.add(new Carro(3L, "Brasilia" ));
		
		return carros;
	};

};
