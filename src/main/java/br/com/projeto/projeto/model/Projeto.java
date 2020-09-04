package br.com.projeto.projeto.model;

public class Projeto {
	private String nomeProjeto;
	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	private int prazo;

	public Projeto(String nomeProjeto, int prazo) {
		this.nomeProjeto = nomeProjeto;
		this.prazo = prazo;

	}

}
