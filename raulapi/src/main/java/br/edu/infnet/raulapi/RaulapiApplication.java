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
        List<Venda> vendas = new ArrayList<>();
        
        ArquivoService arquivoService = new ArquivoService(corretores, imoveis);

        try {
            arquivoService.carregar();
            System.out.println("Dados carregados dos arquivos.\n");
        } catch (IOException e) {
            System.out.println("Não foi possível carregar arquivos.");
        }

        Corretor corretor1 = new Corretor("Raul Frota", 3500);
        Corretor corretor2 = new Corretor("Elberth Moraes", 4300);

        corretores.add(corretor1);
        corretores.add(corretor2);

           Imovel imovel1 = new Imovel(
                "IMV001",
                "Avenida Mario Ypiranga, 100",
                250,
                500000,
                TipoImovel.CASA
        );

        Imovel imovel2 = new Imovel(
                "IMV002",
                "Avenida Brasil, 1101",
                500,
                900000,
                TipoImovel.GALPAO
        );

        imoveis.add(imovel1);
        imoveis.add(imovel2);
   
        try {
            Venda venda1 = new Venda(corretor1, imovel1, imovel1.getValorVenda());
            vendas.add(venda1);

            Venda venda2 = new Venda(corretor2, imovel2, imovel2.getValorVenda());
            vendas.add(venda2);

        } catch (Exception e) {
            System.out.println("Erro ao registrar venda: " + e.getMessage());
        }

        System.out.println("\nCORRETORES");
        for (Corretor c : corretores) {
            c.exibirInformacoes();
            System.out.println();
        }

        System.out.println("\nIMÓVEIS");
        for (Imovel i : imoveis) {
            i.exibirInformacoes();
            System.out.println("Disponível: " + i.isDisponivel());
            System.out.println();
        }

        System.out.println("\nVENDAS");
        for (Venda v : vendas) {
            System.out.println(v);
        }

        try {
            arquivoService.salvar();
            System.out.println("\nDados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivos.");
        }
    }
}