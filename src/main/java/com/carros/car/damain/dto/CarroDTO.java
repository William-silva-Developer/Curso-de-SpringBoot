package com.carros.car.damain.dto;

import com.carros.car.damain.Carro;

import lombok.Data;

@Data
public class CarroDTO {
	
	private Long id;
	
	private String nome;
	private String tipo;
	
	public CarroDTO(Carro car) {
		this.id = car.getId();
		this.nome = car.getNome();
		this.tipo = car.getTipo();
	};
	
	
	

};
