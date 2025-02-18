package contabancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import contabancaria.controller.ContaController;
import contabancaria.model.ContaCorrente;
import contabancaria.model.ContaPoupanca;
import contabancaria.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner input = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Miqueias França", 130157f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Luan França", 280901f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Liam França", 51024f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Sâmia França", 291203f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {
            
            System.out.println(Cores.PASTEL_AZUL + "______________________________________________");
            System.out.println("|                                             |");
            System.out.println("|           " + Cores.RESET + Cores.NEGRITO + "> ---- FAKIH BANK ---- <" + Cores.RESET + Cores.PASTEL_AZUL + "          |");
            System.out.println("|_____________________________________________|");
            System.out.println("|                                             |");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       1. Criar conta" + Cores.RESET + Cores.PASTEL_AZUL + "                        |");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       2. Listar todas as contas             " + Cores.PASTEL_AZUL + "|");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       3. Buscar conta por número            " + Cores.PASTEL_AZUL + "|");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       4. Atualizar dados da conta           " + Cores.PASTEL_AZUL + "|");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       5. Apagar a conta                     " + Cores.PASTEL_AZUL + "|");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       6. Sacar                              " + Cores.PASTEL_AZUL + "|");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       7. Depositar                          " + Cores.PASTEL_AZUL + "|");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_VERDE + "       8. Transferir valores entre contas    " + Cores.PASTEL_AZUL + "|");
            System.out.println("|                                             |");
            System.out.println("|" + Cores.RESET + Cores.PASTEL_ROSA + "       9. Sair                               " + Cores.PASTEL_AZUL + "|");
            System.out.println("|_____________________________________________|");
            System.out.println("|                                             |");
            System.out.println("|    " + Cores.RESET + Cores.ITALICO + Cores.NEGRITO + "Por favor, entre com a opção desejada" + Cores.RESET + Cores.PASTEL_AZUL + "    |");
            System.out.println("|_____________________________________________|" + Cores.RESET);

            try {
				opcao = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				input.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
                System.out.println(Cores.PASTEL_LARANJA + Cores.NEGRITO + "\n               Fakih Bank:");
                System.out.println(Cores.PASTEL_VERDE + Cores.ITALICO + "\n  De F a K, soluções para transformar");
                sobre();
				input.close();
				System.out.println("\nPrograma finalizado.");
				System.exit(0);

			}

			switch (opcao) {
			case 1 -> {
				System.out.println(Cores.PASTEL_LARANJA + "Criar conta\n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = input.nextInt();

				System.out.println("Digite o Nome do Titular: ");
				input.skip("\\R?");
				titular = input.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = input.nextInt();
				} while (tipo != 1 && tipo != 2);

				System.out.println("Digite o Saldo da Conta: ");
				saldo = input.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito da Conta Corrente: ");
					limite = input.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversário da Conta Poupança: ");
					aniversario = input.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}

				keyPress();
				break;
			}
			case 2 -> {
				System.out.println(Cores.PASTEL_LARANJA + "Listar todas as Contas\n\n");

				contas.listarTodas();

				keyPress();
				break;
			}
			case 3 -> {
				System.out.println(Cores.PASTEL_LARANJA + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = input.nextInt();
				contas.procurarPorNumero(numero);

				keyPress();
				break;
			}
			case 4 -> {
				System.out.println(Cores.PASTEL_LARANJA + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta que deseja atualizar: ");
				numero = input.nextInt();

				var contaProcurada = contas.buscarNaCollection(numero);

				if (contaProcurada != null) {

					tipo = contaProcurada.getTipo();

					System.out.println("Digite o Número da Agência: ");
					agencia = input.nextInt();
					System.out.println("Digite o Nome do(a) Titular: ");
					input.skip("\\R?");
					titular = input.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = input.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$) da Conta Corrente: ");
						limite = input.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = input.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}

				keyPress();
				break;
			}
			case 5 -> {
				System.out.println(Cores.PASTEL_ROSA + "Apagar Conta\n\n");
				System.out.println("Digite o número da conta que deseja apagar: ");
				numero = input.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			}
			case 6 -> {
				System.out.println(Cores.PASTEL_VERDE + "Saque\n\n");

				System.out.println("Digite o Número da Conta de Origem do Saque: ");
				numero = input.nextInt();
				
				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = input.nextFloat();
				} while (valor <= 0); 

				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			}
			case 7 -> {
				System.out.println(Cores.PASTEL_LARANJA + "Depósito\n\n");
				
				System.out.println("Digite o Número da Conta de Destino do Depósito: ");
				numero = input.nextInt();
				
				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = input.nextFloat();
				} while (valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			}
			case 8 -> {
				System.out.println(Cores.PASTEL_AZUL + "Transferência Entre Contas\n\n");
				
				System.out.println("Digite o Número da Conta de Origem: ");
				numero = input.nextInt();
				System.out.println("Digite o Número da Conta de Destino: ");
				numeroDestino = input.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = input.nextFloat();
				} while (valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			}
			default -> {
				System.out.println(Cores.PASTEL_ROSA + "\nOpção Inválida!\n");

				keyPress();
				break;
			}
			}
		}
	}

	public static void sobre() {
        System.out.println(Cores.PASTEL_ROSA + "\n_______________________________________");
        System.out.println(Cores.PASTEL_CINZA + "        Projeto desenvolvido por:");
        System.out.println(Cores.PASTEL_VIOLA + "          Sâmia El Fakih França");
        System.out.println(Cores.PASTEL_CINZA + "         samiaf@genstudents.org");
        System.out.println(Cores.PASTEL_VIOLA + "\n           github.com/miaelfk");
        System.out.println(Cores.PASTEL_ROSA + "\n_______________________________________\n");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.PASTEL_AZUL + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("\nVocê pressionou uma tecla diferente de Enter!");
		}
	}
}
