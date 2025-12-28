package desafio_dio_banco.banco_online;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		System.out.println("Conta Poupanca de "+cliente.getNome()+" criada!\n");
	}
	@Override
	public void imprimirExtrato() {
		System.out.println("\n=== Extrato Conta Poupanca ===");
		super.imprimirInfosComuns();
	}
}
