package com.carros.car.damain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
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

	
	//MÉTODO PARA BUSCAR CARRO POR ID
	public Optional<Carro> getCarFindId(Long id) {	
		return repCar.findById(id); 
	}

	//MÉTODO PARA BUSCAR POR TIPO
	public Iterable<Carro> getCarByTipo(String tipo) {
		// TODO Auto-generated method stub
		return repCar.findByTipo(tipo);
	}

	//MÉTODO PARA SALVAR UM CARRO
	public Carro insert(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o novo registro.");
		
	  return	repCar.save(carro);
		
		
	}


	public Carro update(Carro carro, Long id) {
		//VERIFICAR SE O ID EXISTE. CASO NÃO EXISTA O MÉTODO RETORNARÁ ESTÁ MENSAGEM
		Assert.notNull(id, "Não foi possível atualizar o registro.");
		
		Optional<Carro> optional = getCarFindId(id);
		if(optional.isPresent()) {
			Carro db = optional.get();
			
			//FAZENDO UMA COPIA DAS PROPRIEDADES DO OBJETO
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id:" + db.getId());
			
			//ATUALIZANDO O CARRO
			repCar.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possível atualizar o registro.");
		}
		
	}

	//MÉTODO PARA DELETAR O OBJETO PELO ID
	public void delete(Long id) {
		
		Optional<Carro> optional = getCarFindId(id);
		if(optional.isPresent()) {
			repCar.deleteById(id);
		};
		
		
	};
	
	
	
};

























