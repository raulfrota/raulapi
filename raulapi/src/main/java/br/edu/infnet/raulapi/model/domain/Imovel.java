package br.edu.infnet.raulapi.model.domain;

public class Imovel {
	public String codigo;
	public String endereco;
	public int metragem;
	public double valorVenda;
	public boolean disponivel;
	

private double calcularComissao() {
	return valorVenda * 0.06;
	
}

public void exibirInformacoes() {
	double comissao = calcularComissao();
	System.out.println("Código do Imóvel: " + codigo);
	System.out.println("Endereço do Imóvel: " + endereco);
	System.out.println("Tamanho do Imóvel: " + metragem + "m²");
	System.out.println("Valor de Venda: R$" + valorVenda);
	System.out.println("Valor gerado de comissão: R$ " + comissao);
	System.out.println("O Imóvel " + codigo + " foi cadastrado com sucesso!!!");
	}
	
}
