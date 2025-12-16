package br.edu.infnet.raulapi.model.domain;

public class Imovel {
	private String codigo;
	private String endereco;
	private int metragem;
	private double valorVenda;
	private boolean disponivel;
	private TipoImovel tipo;
	
	 public static final double TAXA_COMISSAO = 0.06;
	
	 public Imovel() {
	    }

	    public Imovel(String codigo, String endereco, int metragem, double valorVenda, TipoImovel tipo) {
	    	if (valorVenda <= 0) {
	            throw new IllegalArgumentException("Valor do imóvel inválido.");
	        }
            this.codigo = codigo;
	        this.endereco = endereco;
	        this.metragem = metragem;
	        this.valorVenda = valorVenda;
	        this.tipo = tipo;
	        this.disponivel = true;
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

	

public double calcularComissao() {
	return valorVenda * TAXA_COMISSAO;	
}

public void vender() {
    if (!disponivel) {
        throw new IllegalStateException("Imóvel já vendido.");
    }
    this.disponivel = false;
}

public void exibirInformacoes() {
	double comissao = calcularComissao();
	System.out.println("Código do Imóvel: " + codigo);
	System.out.println("Endereço do Imóvel: " + endereco);
	System.out.println("Tamanho do Imóvel: " + metragem + "m²");
	System.out.println("Valor de Venda: R$" + valorVenda);
	System.out.println("Valor gerado de comissão: R$ " + comissao);
	}
}
