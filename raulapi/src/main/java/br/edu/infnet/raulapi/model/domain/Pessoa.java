package br.edu.infnet.raulapi.model.domain;

public abstract class Pessoa {
	
protected String nome;

public Pessoa (String nome) {
	this.nome = nome;
}

public String getNome() {
	return nome;
}

public abstract void exibirInformacoes();
}
