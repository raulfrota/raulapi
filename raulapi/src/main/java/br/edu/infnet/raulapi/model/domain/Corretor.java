package br.edu.infnet.raulapi.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Corretor extends Pessoa {

private double salario;
private List<Venda> vendas;

public Corretor(String nome, double salario) {
    super(nome);
    if (salario <= 0) {
        throw new IllegalArgumentException("Salário deve ser maior que zero.");
    }
    this.salario = salario;
    this.vendas = new ArrayList<>();
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
	   if (nome == null || nome.isEmpty()) {
	        throw new IllegalArgumentException("Nome do corretor não pode ser vazio.");
	    }
    this.nome = nome;
}

public double getSalario() {
    return salario;
}

public void setSalario(double salario) {
    this.salario = salario;
}


public List<Venda> getVendas() {
    return vendas;
}


public void adicionarVenda(Venda venda) {
	  if (venda == null) {
          throw new IllegalArgumentException("Venda inválida.");
      }
      vendas.add(venda);
  }

@Override
public void exibirInformacoes() {
    System.out.println("Corretor: " + nome);
    System.out.println("Salário fixo: R$ " + salario);
    System.out.println("Total de vendas: " + vendas.size());
}
}

