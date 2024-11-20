package com.ngo.tomada_inteligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ngo.tomada_inteligente.model.Tomada;
import com.ngo.tomada_inteligente.repository.TomadaRepository;
import com.ngo.tomada_inteligente.service.ArduinoService;
import com.ngo.tomada_inteligente.service.TomadaService;

@Controller
public class TomadaController {
	
	@Autowired
	private TomadaRepository tRepo;
	
	@Autowired
	private ArduinoService arduino;
	
	@Autowired
	private TomadaService tServ;
	
	@GetMapping("/home/{id}")
	public String home(Model model, @PathVariable("id") int id) {
		String [] dados = arduino.separarDados(arduino.comunicacaoS(0));
		tServ.criandoTomadas(dados);
		List<Tomada> tomadas =  tRepo.findAll();
		model.addAttribute("tomadas", tomadas);
		model.addAttribute("tomadaS", tRepo.findById(id));
		return "index";
	}

}
