package br.edu.infnet.raulapi.model.domain;

public class Corretor {
public String nome;
public double salario;
public int qtdVendas;

private double calcularComissao() {
	return qtdVendas * 2000;
	
}

public void exibirInformacoes() {
	double comissao = calcularComissao();
	System.out.println("Nome do Corretor: " + nome);
	System.out.println("Salário do Corretor: R$ " + salario);
	System.out.println("Quantidade de Vendas: " + qtdVendas);
	System.out.println("Valor de Comissão: R$" + comissao);
	System.out.println("Valor Total: R$" + (comissao + salario));
	System.out.println("O corretor " + nome + " foi cadastrado com sucesso!!!");
	}
}

