package com.carros.car.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.carros.car.damain.Carro;

public interface CarroRepository extends CrudRepository<Carro, Long> {

	
	//MÉTODO PARA BUSCAR POR TIPO
	List<Carro> findByTipo(String tipo);

	

}
