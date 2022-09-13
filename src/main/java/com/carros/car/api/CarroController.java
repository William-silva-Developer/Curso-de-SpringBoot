package com.carros.car.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.car.damain.Carro;
import com.carros.car.damain.CarroService;
import com.carros.car.damain.dto.CarroDTO;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
	
	@Autowired
	private CarroService service;
	
	@GetMapping()
	public ResponseEntity<List<CarroDTO>> getCar(){
			return ResponseEntity.ok(service.getCarros());		//RETORNARÁ O STATUS 200
		
	};
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CarroDTO> getCarId(@PathVariable("id") Long id){
		//return service.getCarFindId(id);
		Optional<CarroDTO> carro = service.getCarFindId(id);
		
		return carro.isPresent() ? 
				ResponseEntity.ok(carro.get()) :					//O MÉTODO COMENTADO ESTÁ CORRETO, PORÉM DEIXEI ATIVO O TERNÁRIO POR SER MAIS ENXUTO.
					ResponseEntity.notFound().build();
																	//RETORNARÁ O STATUS 404 CASO NÃO ENCONTRE.
		/*if(carro.isPresent()) {
			return ResponseEntity.ok(carro.get());
		}else {
			return ResponseEntity.notFound().build();
		};
		*/
	};
	
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CarroDTO>>  getCarTipo(@PathVariable("tipo") String tipo){
		List<CarroDTO> carros = service.getCarByTipo(tipo);
		
		return carros.isEmpty() ?
				ResponseEntity.noContent().build() :
					ResponseEntity.ok(carros);			//CASO O TIPO NÃO EXISTA O RETORNO DO STATUS SERÁ 204,CASO EXISTA RETORNARÁ O TIPO E O STATUS SERÁ 200.
		
	};
	
	
	@PostMapping
	public void SaveCar(@RequestBody Carro carro) {
		service.insert(carro);
		
	};
	
	@PutMapping("/{id}")
	public void Update(@PathVariable("id") Long id, @RequestBody Carro carro) {
		service.update(carro, id);
		
	};
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return "Objeto deletado com sucesso!";
	};
	
	
};




























