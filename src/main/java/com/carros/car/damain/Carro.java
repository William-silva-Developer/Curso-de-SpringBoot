package com.carros.car.damain;

public class Carro {
	
	private Long id;
	private String name;
	
	
	public Carro(Long id, String nome) {
		this.id = id;
		this.name = nome;
	};


	public Long getId() {
		return id;
	};


	public void setId(Long id) {
		this.id = id;
	};


	public String getNome() {
		return name;
	};


	public void setNome(String nome) {
		this.name = nome;
	};
	
	

}
