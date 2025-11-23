package br.edu.infnet.raulapi.model.domain;

	import java.time.LocalDate;

	public class Venda {

	    private Corretor corretor;
	    private Imovel imovel;
	    private double valorFinal;
	    private LocalDate data;

	    public Venda() {
	        this.data = LocalDate.now();
	    }

	    public Venda(Corretor corretor, Imovel imovel, double valorFinal) {
	        this();
	        this.corretor = corretor;
	        this.imovel = imovel;
	        this.valorFinal = valorFinal;
	    }

	    public Corretor getCorretor() {
	        return corretor;
	    }

	    public Imovel getImovel() {
	        return imovel;
	    }

	    public double getValorFinal() {
	        return valorFinal;
	    }

	    public LocalDate getData() {
	        return data;
	    }

	    @Override
	    public String toString() {
	        return "Venda{" +
	                "corretor=" + corretor.getNome() +
	                ", imovel=" + imovel.getCodigo() +
	                ", valorFinal=" + valorFinal +
	                ", data=" + data +
	                '}';
	    }
	}