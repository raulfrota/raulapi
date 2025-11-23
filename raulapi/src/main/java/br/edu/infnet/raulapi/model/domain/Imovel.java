package br.edu.infnet.raulapi.model.domain;

public class Imovel {
	public String codigo;
	public String endereco;
	public int metragem;
	public double valorVenda;
	public boolean disponivel;
	public TipoImovel tipo;
	
	 public Imovel() {
	    }

	    public Imovel(String codigo, String endereco, int metragem, double valorVenda, boolean disponivel, TipoImovel tipo) {
	        this.codigo = codigo;
	        this.endereco = endereco;
	        this.metragem = metragem;
	        this.valorVenda = valorVenda;
	        this.disponivel = disponivel;
	        this.tipo = tipo;
	    }

	    public String getCodigo() { return codigo; }
	    public void setCodigo(String codigo) { this.codigo = codigo; }

	    public String getEndereco() { return endereco; }
	    public void setEndereco(String endereco) { this.endereco = endereco; }

	    public int getMetragem() { return metragem; }
	    public void setMetragem(int metragem) { this.metragem = metragem; }

	    public double getValorVenda() { return valorVenda; }
	    public void setValorVenda(double valorVenda) { this.valorVenda = valorVenda; }

	    public boolean isDisponivel() { return disponivel; }
	    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

	    public TipoImovel getTipo() { return tipo; }
	    public void setTipo(TipoImovel tipo) { this.tipo = tipo; }

	

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
	}

@Override
public String toString() {
    return "Imovel{" +
            "codigo='" + codigo + '\'' +
            ", endereco='" + endereco + '\'' +
            ", metragem=" + metragem +
            ", valorVenda=" + valorVenda +
            ", disponivel=" + disponivel +
            ", tipo=" + tipo +
            '}';
}
	
}
