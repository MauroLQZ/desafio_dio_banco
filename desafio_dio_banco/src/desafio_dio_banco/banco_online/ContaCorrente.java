package desafio_dio_banco.banco_online;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
		super(cliente);  
		System.out.println("Conta Corrente de "+cliente.getNome()+" criada!\n");
	}
	@Override
	public void imprimirExtrato() {
		System.out.println("\n=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
}   