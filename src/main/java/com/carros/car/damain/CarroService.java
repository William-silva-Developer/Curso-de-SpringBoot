package com.carros.car.damain;

import java.util.ArrayList;
import java.util.List;


public class CarroService {
	
	public List<Carro> getCarros(){
		
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro(1L, "Fusca" ));
		carros.add(new Carro(2L, "Chevette" ));
		carros.add(new Carro(3L, "Brasilia" ));
		
		return carros;
	};

};
