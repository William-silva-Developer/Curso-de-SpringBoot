package com.carros.car.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.car.damain.Carro;
import com.carros.car.damain.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
	
	private CarroService service = new CarroService();
	
	@GetMapping()
	public List<Carro> get(){
		return service.getCarros();
	}

}
