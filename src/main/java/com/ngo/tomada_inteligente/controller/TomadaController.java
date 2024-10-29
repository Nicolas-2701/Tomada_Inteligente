package com.ngo.tomada_inteligente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ngo.tomada_inteligente.service.ArduinoService;

@Controller
public class TomadaController {
	
	@Autowired
	private ArduinoService arduino;
	
	@GetMapping("/home")
	public String home() {
		String [] dados = arduino.separarDados(arduino.comunicacaoS(0));//[0] = watts; [1] = volts que calculam a corrente(remover); [2] = corrente
		return "home";
	}

}
