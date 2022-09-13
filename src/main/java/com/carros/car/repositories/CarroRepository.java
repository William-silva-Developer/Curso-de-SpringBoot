package com.carros.car.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.carros.car.damain.Carro;
import com.carros.car.damain.dto.CarroDTO;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	
	//MÉTODO PARA BUSCAR POR TIPO
	List<Carro> findByTipo(String tipo);

	void save(CarroDTO db);

	

}
