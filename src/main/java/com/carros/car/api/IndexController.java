package com.carros.car.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping()
	public String getAll() {
		return "Olá, sou o index. Estou em desenvolvimento ainda. Aguarde que logo mais estaremos pronto.";
	}

}
