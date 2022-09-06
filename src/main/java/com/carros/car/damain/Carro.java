package com.carros.car.damain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	
	//CONSTRUTOR VAZIO
	public Carro() {
		
	};
	
	
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
