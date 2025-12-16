package br.edu.infnet.raulapi.model.domain;

	import java.time.LocalDate;

	public class Venda {

	    private Corretor corretor;
	    private Imovel imovel;
	    private double valorFinal;
	    private LocalDate data;

	    public Venda(Corretor corretor, Imovel imovel, double valorFinal) {

	        if (!imovel.isDisponivel()) {
	            throw new IllegalStateException("Imóvel indisponível.");
	        }

	        if (valorFinal <= 0) {
	            throw new IllegalArgumentException("Valor final inválido.");
	        }

	        this.corretor = corretor;
	        this.imovel = imovel;
	        this.valorFinal = valorFinal;
	        this.data = LocalDate.now();

	        imovel.vender();
	        corretor.adicionarVenda(this);
	    }

	    public double getValorFinal() {
	        return valorFinal;
	    }

	    public double getComissao() {
	        return valorFinal * Imovel.TAXA_COMISSAO;
	    }

	    @Override
	    public String toString() {
	        return "Venda{" +
	                "corretor=" + corretor.getNome() +
	                ", imovel=" + imovel.getCodigo() +
	                ", valorFinal=" + valorFinal +
	                ", comissao=" + getComissao() +
	                ", data=" + data +
	                '}';
	    }
	}