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
	private TomadaRepository tomadaRepository;
	
	@Autowired
	private ArduinoService arduinoService;
	
	@Autowired
	private TomadaService tomadaService;
	
	@GetMapping("/home/{id}")
	public String home(Model model, @PathVariable("id") int id) {
		String [] dados = arduinoService.separarDados(arduinoService.comunicacaoS(0));
		tomadaService.criandoTomadas(dados);
		List<Tomada> tomadas =  tomadaRepository.findAll();
		double tsGt = tomadas.stream().mapToDouble(Tomada::getGt).sum();//gasto total de todas as tomadas
		double tsW = tomadas.stream().mapToDouble(Tomada::getWatts).sum();//watts de todas as tomadas
		double tsWh = tomadas.stream().mapToDouble(Tomada::getWh).sum();//wh de todas as tomadas
		double tsGr = tomadas.stream().mapToDouble(Tomada::getGr).sum();//gr de todas as tomadas
		model.addAttribute("tsGt", tsGt);
		model.addAttribute("tsW", tsW);
		model.addAttribute("tsWh", tsWh);
		model.addAttribute("tsGr", tsGr);
		model.addAttribute("tomadas", tomadas);
		model.addAttribute("tomadaS", tomadaRepository.findById(id));
		return "index";
	}

}
