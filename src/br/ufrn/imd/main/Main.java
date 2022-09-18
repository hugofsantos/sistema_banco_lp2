package br.ufrn.imd.main;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.imd.dominio.Cliente;
import br.ufrn.imd.dominio.Conta;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		Scanner sc = new Scanner(System.in);
		
		try {
			while (true) {
				System.out
						.println("Digite a opção desejada: \n" 
						+ "1 - novo cliente \n" + "2 - gerenciar cliente \n" + "0 - Sair");
				int opcao = Integer.parseInt(sc.nextLine());

				switch(opcao){
				case 1:
					System.out.println("Digite o nome do cliente:");
					String nome = sc.nextLine();

					System.out.println("Digite o CPF do cliente: ");
					String cpf = sc.nextLine();
					
					Cliente cliente = new Cliente(nome, cpf);

					if(!clientes.contains(cliente)){
						clientes.add(cliente);
						
						System.out.println("Informe o número da conta a ser criada: ");
						cliente.criarConta(new Conta(Integer.parseInt(sc.nextLine())));
					}
					else System.out.println("Cliente já existente!");
					break;
				case 2: 
					System.out.println("Informe o CPF do cliente: ");
					Cliente clienteAtual = encontrarClientePeloCPF(sc.nextLine(), clientes);

					if(clienteAtual != null){
						System.out.printf("Bem vindo à conta de %s!\n" + "Escolha uma opção: \n", clienteAtual.getNome());
						Conta conta = clienteAtual.getConta();
						double valor = 0;
						int numeroConta = 0;

						int opcaoConta = 0;

						do{
							System.out.println("1 - Sacar\n" + "2 - Depositar\n" + "3 - Transferir\n" + "4 - Ver saldo\n" + "5 - Sair");
							opcaoConta = Integer.parseInt(sc.nextLine());
							

							switch(opcaoConta){
								case 1:
									System.out.println("Informe o valor que você deseja sacar: ");
									valor = Double.parseDouble(sc.nextLine());
									
									if(conta.sacar(valor)) System.out.println("Valor sacado com sucesso!");
									else System.out.println("Erro ao sacar valor");
									break;
								case 2:
									System.out.println("Informe o valor que você deseja depositar: ");
									valor = Double.parseDouble(sc.nextLine());
									
									if(conta.depositar(valor)) System.out.println("Valor depositado com sucesso!");
									else System.out.println("Erro ao depositar valor");
									break;
								case 3:
									System.out.println("Informe o número da conta para a qual você deseja transferir: ");
									numeroConta = Integer.parseInt(sc.nextLine());
									
									System.out.println("Informe o valor que você deseja transferir: ");
									valor = Double.parseDouble(sc.nextLine());
									
									Conta contaTransferencia = encontrarContaPeloNumero(numeroConta, clientes);

									if(conta.transferir(valor, contaTransferencia)) System.out.println("Transferência realizada com sucesso!");
									else System.out.println("Erro na transferência");
									break;
								case 4:
									System.out.printf("Saldo da conta: %.2f\n", conta.getSaldo());
									break;
								case 5:
									System.out.println("Saindo do menu de conta!");
									break;
								default: System.out.println("Opção inválida!");

							}
						}while(opcaoConta!=5);
					}else{
						System.out.println("Não existe nenhum cliente cadastrado com esse CPF!");
					}

					break;
				case 0:
					System.exit(0);
				}

			}
		} finally {
			sc.close();
		}
	}

	public static Conta encontrarContaPeloNumero(int numero, ArrayList<Cliente> clientes){
		for(Cliente cliente: clientes){
			Conta conta = cliente.getConta();

			if(conta == null) continue;
			if(conta.getNumero() == numero) return conta;
		}

		return null;		
	}

	public static Cliente encontrarClientePeloCPF(String cpf, ArrayList<Cliente> clientes){
		for(Cliente cliente: clientes){
			if(cliente.getCpf().equals(cpf)) return cliente;
		}

		return null;
	}
}
