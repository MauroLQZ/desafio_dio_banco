package desafio_dio_banco.banco_online;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Banco {
	private String nome;
	private List<Conta> contasList;

	public Banco(String nome) {
		this.nome = nome;
		this.contasList = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return this.contasList;
	}

	public void addContaNaLista(Conta conta) {
		contasList.add(conta);
	}

	// Metodo que retorna a relação das contas por cliente
	public List<Conta> relacaoContaPorCliente() {
		if (!this.contasList.isEmpty()) {
			List<Conta> contasPorCliente = new ArrayList<>(this.contasList);
			contasPorCliente.stream().sorted((c1, c2) -> c1.cliente.getNome().compareTo(c2.cliente.getNome()))
					.collect(Collectors.toList());

			return contasPorCliente;
		} else {
			throw new RuntimeException("A lista de clientes está vazia!");
		}
	}

	// Metodo que retorna a relação de contas por Saldo
	public List<Conta> relacaoContasPorSaldo() {
		if (!contasList.isEmpty()) {
			List<Conta> contasPorSaldo = new ArrayList<>(this.contasList);
			contasPorSaldo.sort((c1, c2) -> Double.compare(c1.getSaldo(), c2.getSaldo()));
			return contasPorSaldo;
		} else {
			throw new RuntimeException("A lista de contas está vazia!");
		}
	}

	// Metodo que retorna a relação de contas por numero da conta.
	public List<Conta> relacaoContasPorNumero() {
		if (!contasList.isEmpty()) {
			List<Conta> contasPorNumero = new ArrayList<>(contasList);
			contasPorNumero.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));
			return contasPorNumero;
		} else {
			throw new RuntimeException("A lista de contas está vazia!");
		}
	}

	// Retornar o saldo de maior valor
	public Conta obterSaldoDeMaiorValor() {
		Conta contaComMaiorSaldo = null;
		double maiorSaldo = Double.MIN_VALUE;
		if (!contasList.isEmpty()) {
			for (Conta conta : contasList) {
				if (conta.getSaldo() > maiorSaldo) {
					maiorSaldo = conta.getSaldo();
					contaComMaiorSaldo = conta;
				}
			}
			return contaComMaiorSaldo;
		} else {
			throw new RuntimeException("A lista de contas está vazia!");
		}
	}

	// método que calcula valor total dos saldos das contas.
	/*
	 * public double calcularValorSaldosTotal() { double valorSaldoTotal = 0d; if
	 * (!this.contasList.isEmpty()) { for (Conta conta : this.contasList) {
	 * valorSaldoTotal += conta.getSaldo(); } return valorSaldoTotal; } else { throw
	 * new RuntimeException("A lista de contas está vazia!"); } }
	 */
	// método que calcula valor total dos saldos das contas.
	public double calcularValorSaldosTotal() {
		double valorSaldoTotal = 0d;
		if (this.contasList.isEmpty()) {
			throw new RuntimeException("A lista de contas está vazia!");
		}
		/*valorSaldoTotal = this.contasList.stream()
				.mapToDouble(c -> c.getSaldo())
				.sum(); // Soma todos os doubles no stream*/
		
		valorSaldoTotal = this.contasList.stream()
				// Some os saldos usando Stream API, lambda e method reference
				.mapToDouble(Conta::getSaldo) // Mapeia os objetos Conta para um Stream de doubles
				.sum(); // Soma todos os doubles no stream

		return valorSaldoTotal;
	}

}
