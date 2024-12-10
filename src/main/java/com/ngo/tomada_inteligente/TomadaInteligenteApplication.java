package com.ngo.tomada_inteligente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ngo.tomada_inteligente.model.Tomada;
import com.ngo.tomada_inteligente.repository.TomadaRepository;

@SpringBootApplication
public class TomadaInteligenteApplication {
	public static void main(String[] args) {
		SpringApplication.run(TomadaInteligenteApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(TomadaRepository tRepo) {
		return args -> {
			//usar para testes, caso precise testar a interface sem arduino
			tRepo.save(new Tomada(1, 0.0, 0.0, 0.0, 0.0));
			tRepo.save(new Tomada(2, 0.0, 0.0, 0.0, 0.0));
			tRepo.save(new Tomada(3, 0.0, 0.0, 0.0, 0.0));
//			tRepo.save(new Tomada(4, 3.0, 2.0, 1.0));
//			tRepo.save(new Tomada(5, 3.0, 2.0, 1.0));
//			tRepo.save(new Tomada(6, 3.0, 2.0, 1.0));
//			tRepo.save(new Tomada(7, 3.0, 2.0, 1.0));
		};
	}
}
