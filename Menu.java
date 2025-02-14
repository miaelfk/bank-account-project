package contabancaria;
import java.util.Scanner;
import contabancaria.model.Contabancaria;
import contabancaria.model.ContaCorrente;
import contabancaria.model.ContaPoupanca;
import contabancaria.util.Cores;
import contabancaria.model.Conta;
public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1, 123, 1, "Sâmia", 1000000.0f);
		c1.visualizar();
		c1.sacar(8654.0f);
		c1.visualizar();
		c1.depositar(50000.0f);
		c1.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Luan", 17500.0f, 10000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Liam", 27500.0f, 15);
		cp1.visualizar();
		cp1.sacar(14350.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		while (true) {
			
			System.out.println(Cores.PASTEL_AZUL + "______________________________________________ " + Cores.RESET);
			System.out.println(Cores.PASTEL_AZUL + "|                                             |");
			System.out.println(Cores.PASTEL_AZUL + "|           " + Cores.RESET + Cores.NEGRITO + "> ---- FAKIH BANK ---- <" + Cores.RESET + Cores.PASTEL_AZUL + "          |" + Cores.RESET);
			System.out.println(Cores.PASTEL_AZUL + "|_____________________________________________|" + Cores.RESET);
			System.out.println(Cores.PASTEL_AZUL + "|                                             |" + Cores.RESET);
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       1. Criar conta" + Cores.RESET + Cores.PASTEL_AZUL + "                        |" + Cores.RESET);
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       2. Listar todas as contas             " + Cores.PASTEL_AZUL +"|");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       3. Buscar conta por número            " + Cores.PASTEL_AZUL + "|");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       4. Atualizar dados da conta           "+ Cores.PASTEL_AZUL + "|");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       5. Apagar a conta                     " + Cores.PASTEL_AZUL + "|");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       6. Sacar                              "+ Cores.PASTEL_AZUL + "|");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       7. Depositar                          " + Cores.PASTEL_AZUL + "|");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_VERDE +"       8. Transferir valores entre contas    " + Cores.PASTEL_AZUL + "|");
			System.out.println(Cores.PASTEL_AZUL + "|                                             |");
			System.out.println(Cores.PASTEL_AZUL + "|" + Cores.RESET + Cores.PASTEL_ROSA +"       9. Sair                               " + Cores.PASTEL_AZUL +"|");
			System.out.println(Cores.PASTEL_AZUL + "|_____________________________________________|");
			System.out.println(Cores.PASTEL_AZUL + "|                                             |");
			System.out.println(Cores.PASTEL_AZUL + "|    " + Cores.RESET + Cores.ITALICO + Cores.NEGRITO + "Por favor, entre com a opção desejada" + Cores.RESET + Cores.PASTEL_AZUL + "    |" + Cores.RESET);
			System.out.println(Cores.PASTEL_AZUL + "|_____________________________________________|" + Cores.RESET);
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.PASTEL_LARANJA + Cores.NEGRITO + "\n               Fakih Bank:");
				System.out.println(Cores.PASTEL_VERDE + Cores.ITALICO + "\n  De F a K, soluções para transformar");
				sobre();
				
			leia.close();
				System.exit(0);
			}
				switch (opcao) {
				case 1:
					System.out.println("Criar Conta \n\n");
					
					break;
				case 2:
					System.out.println("Listar todas as contas\n\n");
					break;
				case 3:
					System.out.println("Buscar conta por número\n\n");
					break;
				case 4:
					System.out.println("Atualizar dados da conta\n\n");
					break;
				case 5:
					System.out.println("Apagar a conta\n\n");
					break;
				case 6:
					System.out.println("Saque\n\n");
					break;
				case 7:
					System.out.println("Depósito\n\n");
					break;
				case 8:
					System.out.println("Transferência entre contas\n\n");
					break;
				default:
					System.out.println("\nOpção Inválida! Digite um número entre 1 e 9, por favor.\n");
					break;
				}
		}
	}
			public static void sobre() {
				System.out.println(Cores.PASTEL_ROSA + "\n_______________________________________\n");
				System.out.println(Cores.PASTEL_CINZA + "        Projeto desenvolvido por:");
				System.out.println(Cores.PASTEL_VIOLA + "          Sâmia El Fakih França");
				
				System.out.println(Cores.PASTEL_CINZA + "\n           Generation Brasil");
				System.out.println(Cores.PASTEL_CINZA + "         samiaf@genstudents.org");
				
				System.out.println(Cores.PASTEL_VIOLA + "\n           github.com/miaelfk");
				System.out.println(Cores.PASTEL_ROSA + "\n_______________________________________\n");
			}

}
