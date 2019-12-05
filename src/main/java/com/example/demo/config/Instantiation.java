package com.example.demo.config;

import com.example.demo.domain.Nutricionista;
import com.example.demo.domain.ChefeCozinha;
import com.example.demo.repository.NutricionistaRepository;
import com.example.demo.repository.ChefeCozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.AlunoRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private NutricionistaRepository nutricionistaRepository;

	@Autowired
	private ChefeCozinhaRepository chefeCozinhaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*repository.deleteAll();
		nutricionistaRepository.deleteAll();
		chefeCozinhaRepository.deleteAll();

		ChefeCozinha cc = new ChefeCozinha();
		cc.setLogin("chefe");
		cc.setSenha("1234");
		chefeCozinhaRepository.save(cc);

		Nutricionista as = new Nutricionista();
		as.setLogin("nutricionista");
		as.setSenha("1234");
		nutricionistaRepository.save(as);*/

		//repository.saveAll(Arrays.asList(a1, a2, a3));
		
	}

}
