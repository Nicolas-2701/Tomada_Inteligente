package com.ngo.tomada_inteligente.service;

import org.springframework.stereotype.Service;

import com.ngo.tomada_inteligente.model.DadosArduino;

@Service
public interface ArduinoService {

	void comunicacaoS(int porta);

}
