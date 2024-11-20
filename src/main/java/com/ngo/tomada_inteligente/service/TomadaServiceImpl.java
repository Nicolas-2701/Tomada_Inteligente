package com.ngo.tomada_inteligente.service;

import com.ngo.tomada_inteligente.model.Tomada;
import com.ngo.tomada_inteligente.repository.TomadaRepository;

public class TomadaServiceImpl implements TomadaService {
	
	private TomadaRepository tRepo;
	
	@Override
	public void criandoTomadas(String [] dados) {
		for(String dadosS : dados) {
			String [] linha = dadosS.split(";");
			int id = Integer.parseInt(linha[0]);
			
			if(tRepo.findById(id) != null) {
				//se a tomada não existir ele cria uma nova
				tRepo.save(new Tomada(id, 
						Double.parseDouble(linha[1]), 
						Double.parseDouble(linha[2]), 
						Double.parseDouble(linha[3])));
			} else {
				//se não, ele substitui os dados
				Tomada tomada = tRepo.findById(id);
				tomada.setWatts(Double.parseDouble(linha[1]));
				tomada.setWh(Double.parseDouble(linha[2]));
				tomada.setGt(Double.parseDouble(linha[3]));
				tRepo.save(tomada);
			}
		}
		
	}

}
