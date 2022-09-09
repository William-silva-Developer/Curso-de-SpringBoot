package com.carros.car.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carros.car.damain.Carro;

public interface CarroRepository extends CrudRepository<Carro, Long> {

	
	//MÉTODO PARA BUSCAR POR TIPO
	Iterable<Carro> findByTipo(String tipo);

	

}
