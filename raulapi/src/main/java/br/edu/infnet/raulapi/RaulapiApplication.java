package br.edu.infnet.raulapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.infnet.raulapi.model.domain.Imovel;
import br.edu.infnet.raulapi.model.domain.Corretor;

@SpringBootApplication
public class RaulapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaulapiApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Iniciando...");
		
		Corretor corretorRaul = new Corretor();
		System.out.print("Informe o nome do Corretor:");
		corretorRaul.nome = in.nextLine();
		System.out.print("Informe o Salário do Corretor:");
		corretorRaul.salario = in.nextDouble();
		System.out.print("Informe a quantidade de vendas do Corretor:");
		corretorRaul.qtdVendas = in.nextInt();
	
		corretorRaul.exibirInformacoes();
		
		Imovel imovel1 = new Imovel();	
		in.nextLine();
		
		System.out.print("Informe o código do Imóvel:");		
		imovel1.codigo = in.nextLine();
		System.out.print("Informe o endereço do Imóvel:");
		imovel1.endereco = in.nextLine();
		System.out.print("Informe a metragem do Imóvel:");
		imovel1.metragem = in.nextInt();
	    System.out.print("Informe o valor de venda do Imóvel:");
		imovel1.valorVenda = in.nextDouble();
		
		imovel1.exibirInformacoes();
		
		System.out.println("Finalizando...");
		
		in.close();
	}

}
