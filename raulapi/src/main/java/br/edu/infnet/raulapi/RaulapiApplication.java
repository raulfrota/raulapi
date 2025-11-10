package br.edu.infnet.raulapi;

import java.util.Scanner;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.infnet.raulapi.model.domain.Imovel;
import br.edu.infnet.raulapi.model.domain.Corretor;

@SpringBootApplication
public class RaulapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaulapiApplication.class, args);
		
		Scanner in = new Scanner(System.in);		

		ArrayList<Corretor> corretores = new ArrayList<>();
		ArrayList<Imovel> imoveis = new ArrayList<>();

		boolean sistemaAtivo = true;

		System.out.println("Iniciando...");
		System.out.println("\nSISTEMA DE GESTÃO IMOBILIÁRIA");

		while (sistemaAtivo) {
			System.out.println("\nSelecione uma opção:");
			System.out.println("1 - Cadastrar Corretor");
			System.out.println("2 - Cadastrar Imóvel");
			System.out.println("3 - Listar Corretores");
			System.out.println("4 - Listar Imóveis");
			System.out.println("5 - Sair");
			System.out.print("Opção: ");
			
			int opcao = in.nextInt();
			in.nextLine();

			switch (opcao) {
				case 1:
					System.out.println("\nCadastro de Corretor");
					Corretor corretor = new Corretor();

					System.out.print("Nome do Corretor: ");
					corretor.nome = in.nextLine();

					System.out.print("Salário: ");
					corretor.salario = in.nextDouble();
				
					System.out.print("Quantidade de vendas: ");
					corretor.qtdVendas = in.nextInt();
					in.nextLine();

	
					if (corretor.qtdVendas >= 10) {
						System.out.println("Corretor de destaque!");
					} else if (corretor.qtdVendas >= 5) {
						System.out.println("Bom desempenho!");
					} else {
						System.out.println("Corretor em treinamento.");
					}

					corretores.add(corretor);
					System.out.println("\nCorretor cadastrado com sucesso.");
					break;

				case 2:
					System.out.println("\nCadastro de Imóvel");
					Imovel imovel = new Imovel();

					System.out.print("Código: ");
					imovel.codigo = in.nextLine();

					System.out.print("Endereço: ");
					imovel.endereco = in.nextLine();

					System.out.print("Metragem (m²): ");
					imovel.metragem = in.nextInt();

					System.out.print("Valor de venda: ");
					imovel.valorVenda = in.nextDouble();

					System.out.print("Disponível para venda (true/false): ");
					imovel.disponivel = in.nextBoolean();
					in.nextLine();

					imoveis.add(imovel);
					System.out.println("\nImóvel cadastrado com sucesso.");
					break;

				case 3:
				    System.out.println("\nDigite o usuário e senha para continuar.");

				    System.out.print("Usuário: ");
				    String usuario = in.nextLine();

				    System.out.print("Senha: ");
				    String senha = in.nextLine();

				    if ("admin".equals(usuario) && "1234".equals(senha)) {
				        System.out.println("Acesso autorizado!");
				        System.out.println("\nLista de Corretores");

				        if (corretores.isEmpty()) {
				            System.out.println("Nenhum corretor cadastrado.");
				        } else {
				            for (Corretor c : corretores) {
				                c.exibirInformacoes();
				            }
				        }

				    } else {
				        System.out.println("Usuário ou senha incorretos.");
				    }
				    break;
		
				case 4:
				    System.out.println("\nDigite o usuário e senha para continuar.");

				    System.out.print("Usuário: ");
				    String usuario2 = in.nextLine();

				    System.out.print("Senha: ");
				    String senha2 = in.nextLine();

				    if (usuario2.equals("admin") && senha2.equals("1234")) {
				        System.out.println("Acesso autorizado!");
				        System.out.println("\nLista de Imóveis");

				        if (imoveis.isEmpty()) {
				            System.out.println("Nenhum imóvel cadastrado.");
				        } else {
				            for (Imovel i : imoveis) {
				                if (!i.disponivel) {
				                    System.out.println("Imóvel " + i.codigo + " está INDISPONÍVEL!");
				                    continue;
				                } else {
				                    i.exibirInformacoes();
				                }
				            }
				        }
				    } else {
				        System.out.println("Usuário ou senha incorretos.");
				    }
				    break;

				case 5:
					System.out.println("Deseja realmente sair? (1 = Sim / 0 = Não)");
					int sair = in.nextInt();

					do {
						if (sair == 1) {
							System.out.println("Encerrando sistema...");
							sistemaAtivo = false;
							break;
						} else if (sair == 0) {
							System.out.println("Voltando ao menu principal...");
							break;
						} else {
							System.out.println("Opção inválida! Digite 1 ou 0.");
							sair = in.nextInt();
						}
					} while (true);

					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}
		}

		in.close();
	}
}