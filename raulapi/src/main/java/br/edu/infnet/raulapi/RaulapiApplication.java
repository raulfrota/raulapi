package br.edu.infnet.raulapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.infnet.raulapi.model.domain.*;
import br.edu.infnet.raulapi.persistencia.*;

@SpringBootApplication
public class RaulapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaulapiApplication.class, args);
		
	
		List<Corretor> corretores = new ArrayList<>();
        List<Imovel> imoveis = new ArrayList<>();

        Persistencia persistencia = new ArquivoService(corretores, imoveis);

        try {
            persistencia.carregar();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados.");
        }

        System.out.println("\nSISTEMA DE GESTÃO IMOBILIÁRIA\n");

        Corretor c1 = new Corretor("Raul", 3000);
        corretores.add(c1);

        Imovel i1 = new Imovel("01", "Avenida Mario Ypiranga", 120, 250000, TipoImovel.CASA);
        imoveis.add(i1);

        Venda v1 = new Venda(c1, i1, 250000);
        System.out.println(v1);

        try {
            persistencia.salvar();
            System.out.println("\nDados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados.");
        }
    }
}