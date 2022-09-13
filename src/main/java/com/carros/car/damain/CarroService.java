package com.carros.car.damain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;

import com.carros.car.damain.dto.CarroDTO;
import com.carros.car.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repCar;
	
	
	//RENDERIZAR TODOS OS CARROS NO NAVEGADOR
	public List<CarroDTO> getCarros(){
		
		
		return repCar.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());
		/*RESUMO: O 'FINDALL()' CHAMA UMA LISTA DE CARROS,
		O MÉTODO 'STREAM' AJUDA A MAPEAR A LISTA E O 'CarroDTO::new' PERCORRE CARRO POR CARRO
		EM SEGUIDA COM O 'collect(Collectors.toList())' É GERADA UMA NOVA LISTA DE CARRODTO. 
		*/
	}

	
	//MÉTODO PARA BUSCAR CARRO POR ID
	public Optional<CarroDTO> getCarFindId(Long id) {	
		return repCar.findById(id).map(CarroDTO::new);
	}

	//MÉTODO PARA BUSCAR POR TIPO
	public List<CarroDTO> getCarByTipo(String tipo) {
	
		return repCar.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
	}

	//MÉTODO PARA SALVAR UM CARRO
	public Carro insert(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o novo registro.");
		
	  return	repCar.save(carro);
		
		
	}


	public CarroDTO update(Carro carro, Long id) {
		//VERIFICAR SE O ID EXISTE. CASO NÃO EXISTA O MÉTODO RETORNARÁ ESTÁ MENSAGEM
		Assert.notNull(id, "Não foi possível atualizar o registro.");
		
		Optional<CarroDTO> optional = getCarFindId(id);
		if(optional.isPresent()) {
			CarroDTO db = optional.get();
			
			//FAZENDO UMA COPIA DAS PROPRIEDADES DO OBJETO
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
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
		
		
		if(getCarFindId(id).isPresent()) {
			repCar.deleteById(id);
		};
		
		
	};
	
	
	
};

























