package br.edu.infnet.raulapi.persistencia;

import br.edu.infnet.raulapi.model.domain.Corretor;
import br.edu.infnet.raulapi.model.domain.Imovel;
import br.edu.infnet.raulapi.model.domain.TipoImovel;

import java.io.*;
import java.util.List;

public final class ArquivoService implements Persistencia {
	 private static final String ARQ_CORRETORES = "corretores.txt";
	    private static final String ARQ_IMOVEIS = "imoveis.txt";

	    private List<Corretor> corretores;
	    private List<Imovel> imoveis;

	    public ArquivoService(List<Corretor> corretores, List<Imovel> imoveis) {
	        this.corretores = corretores;
	        this.imoveis = imoveis;
	    }

	    @Override
	    public void salvar() throws IOException {

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQ_CORRETORES))) {
	            for (Corretor c : corretores) {
	                bw.write(c.getNome() + ";" + c.getSalario());
	                bw.newLine();
	            }
	        }

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQ_IMOVEIS))) {
	            for (Imovel i : imoveis) {
	                bw.write(i.getCodigo() + ";" + i.getEndereco() + ";" +
	                         i.getMetragem() + ";" + i.getValorVenda() + ";" +
	                         i.getTipo());
	                bw.newLine();
	            }
	        }
	    }

	    @Override
	    public void carregar() throws IOException {
	    	 corretores.clear();
	         imoveis.clear();

	         File f1 = new File(ARQ_CORRETORES);
	        if (f1.exists()) {
	            try (BufferedReader br = new BufferedReader(new FileReader(f1))) {
	                String linha;
	                while ((linha = br.readLine()) != null) {
	                    String[] d = linha.split(";");
	                    corretores.add(new Corretor(d[0], Double.parseDouble(d[1])));
	                }
	            }
	        }

	        File f2 = new File(ARQ_IMOVEIS);
	        if (f2.exists()) {
	            try (BufferedReader br = new BufferedReader(new FileReader(f2))) {
	                String linha;
	                while ((linha = br.readLine()) != null) {
	                    String[] d = linha.split(";");
	                    imoveis.add(new Imovel(
	                            d[0], d[1],
	                            Integer.parseInt(d[2]),
	                            Double.parseDouble(d[3]),
	                            TipoImovel.valueOf(d[4])
	                    ));
	                }
	            }
	        }
	    }
	}
