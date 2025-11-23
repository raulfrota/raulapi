package br.edu.infnet.raulapi.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Corretor {
public String nome;
public double salario;
public int qtdVendas;
public List<Venda> vendas = new ArrayList<>();

public Corretor() {
}

public Corretor(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public double getSalario() {
    return salario;
}

public void setSalario(double salario) {
    this.salario = salario;
}

public int getQtdVendas() {
    return qtdVendas;
}

public void setQtdVendas(int qtdVendas) {
    this.qtdVendas = qtdVendas;
}

public List<Venda> getVendas() {
    return vendas;
}

private double calcularComissao() {
	return qtdVendas * 500;
	
}

public void exibirInformacoes() {
	double comissao = calcularComissao();
	System.out.println("Nome do Corretor: " + nome);
	System.out.println("Salário do Corretor: R$ " + salario);
	System.out.println("Quantidade de Vendas: " + qtdVendas);
	System.out.println("Valor de Comissão: R$" + comissao);
	System.out.println("Valor Total: R$" + (comissao + salario));
	System.out.println("");
	}

public void adicionarVenda(Venda venda) {
    vendas.add(venda);
    this.qtdVendas++;
}

public void adicionarVenda(Imovel imovel, double valorFinal) {
    vendas.add(new Venda(this, imovel, valorFinal));
    this.qtdVendas++;
}

@Override
public String toString() {
    return "Corretor{" +
            "nome='" + nome + '\'' +
            ", salario=" + salario +
            ", qtdVendas=" + qtdVendas +
            ", vendasRegistradas=" + vendas.size() +
            '}';
}

}

