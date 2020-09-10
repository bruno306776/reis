package br.com.projeto.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.projeto.model.Projeto;

@RestController
public class ProjetoController {

	@GetMapping(path = "/", produces = "application/json")
	public Projeto projeto() {
		return new Projeto("tarefa", 100);
	}

}
