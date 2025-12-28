package desafio_dio_banco.banco_online;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private List<Cliente> clientesList = new ArrayList<Cliente>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.clientesList.add(cliente);
	}

	// Metodo que retorna a relação das contas por cliente
	public List<Cliente> relacaoPorCliente() {
		if (!this.clientesList.isEmpty()) {
			List<Cliente> relacaoClientes = new ArrayList<>(this.clientesList);
			relacaoClientes.stream().sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome()))
					.collect(Collectors.toList());

			return relacaoClientes;
		} else {
			throw new RuntimeException("A lista de clientes está vazia!");
		}
	}

	@Override
	public void sacar(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo!");
		} else if (valor > this.saldo) {
			throw new SaldoInsuficienteException(valor);
		} else {
			this.saldo -= valor;
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo!");
		} else {
			this.saldo += valor;
			System.out.println("Deposito de " + valor + " realizado!");
			System.out.println("Saldo Atual: " + this.saldo + "\n");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor < 0) {
			throw new IllegalArgumentException("ERRO! Você digitou um valor negativo para " + "transferencia!");
		} else if (valor > this.saldo) {
			throw new SaldoInsuficienteException(valor);
		} else {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("Foi sacado o valor " + valor + " para Transferencia!");
			System.out.println("Saldo Atual: " + this.saldo + "\n");
			System.out.println("Transferencia realizada!");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println("------------------------------");
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("CPF: %d", this.cliente.getCpf()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
