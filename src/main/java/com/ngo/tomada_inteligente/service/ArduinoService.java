package com.ngo.tomada_inteligente.service;

import org.springframework.stereotype.Service;

import com.ngo.tomada_inteligente.model.DadosArduino;

@Service
public interface ArduinoService {

	String comunicacaoS(int porta);
	String[] separarDados(String dados);

}
