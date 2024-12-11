package com.ngo.tomada_inteligente.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.tomada_inteligente.model.Tomada;
import com.ngo.tomada_inteligente.repository.TomadaRepository;

@Service
public class TomadaServiceImpl implements TomadaService {
	
	@Autowired
	private TomadaRepository tRepo;
	
	@Override
	public void criandoTomadas(String [] dados) {
		for(String dadosS : dados) {
			String [] linha = dadosS.split(";");
			System.out.print("LINHA:");
			System.out.println(Arrays.toString(linha));
			try {
				int id = Integer.parseInt(linha[0].replace("*", "").trim());
			
				try{
					tRepo.findById(id);
					//	se a tomada não existir ele cria uma nova
					tRepo.save(new Tomada(id, 
						Double.parseDouble(linha[1]), 
						Double.parseDouble(linha[2]), 
						Double.parseDouble(linha[3]),
						Double.parseDouble(linha[4])));
				} catch (Exception e) {
					System.out.println("CATCH\n"+e);
					//se não, ele substitui os dados
					Tomada tomada = tRepo.findById(id);
					tomada.setWatts(Double.parseDouble(linha[1]));
					tomada.setWh(Double.parseDouble(linha[2]));
					tomada.setGt(Double.parseDouble(linha[3]));
					tomada.setGr(Double.parseDouble(linha[4]));
					tRepo.save(tomada);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
