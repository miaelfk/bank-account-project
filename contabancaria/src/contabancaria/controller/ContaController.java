package contabancaria.controller;

import java.util.ArrayList;
import contabancaria.model.Conta;
import contabancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	public int gerarNumero() {
		return ++numero;
	}

	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}
	}

	public void atualizar(Conta conta) {

		var contaProcurada = buscarNaCollection(conta.getNumero());

		if (contaProcurada != null) {
			listaContas.set(listaContas.indexOf(contaProcurada), conta);
			System.out.println("\nA Conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA Conta número: " + conta.getNumero() + " não foi encontrada.");
		}

	}

	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println("\nA Conta número: " + numero + " foi deletada com sucesso!");
			}
		} else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}
	}

	public void sacar(int numero, float valor) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true) {
				System.out.println("\nO Saque no valor de R$" + valor + ", na Conta de número: " + numero
						+ ", foi efetuado com sucesso!");
			}
		} else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}

	}

	public void depositar(int numero, float valor) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nO Depósito na Conta número: " + numero + " foi efetuado com sucesso!");
		} else {
			System.out.println(
					"\nA Conta número: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");
		}

	}

	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA Transferência no valor de R$" + valor
						+ "foi efetuada com sucesso!\nNúmero da Conta de Origem: " + contaOrigem.getNumero()
						+ "\nNúmero da Conta de Destino: " + contaDestino.getNumero());
			}
		} else {
			System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
		}
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}

	public void cadastrar(ContaController contabancaria) {
		
	}

	public void atualizar(ContaController contabancaria) {
		
	}
}
