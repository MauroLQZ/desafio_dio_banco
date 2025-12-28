package desafio_dio_banco.banco_online;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		/*String nome = "Mauro";
		int cpf = 123456789;
		Cliente mauro = new Cliente(nome, cpf);

		Conta cc = new ContaCorrente(mauro);
		Conta poupanca = new ContaPoupanca(mauro);
		try {
			cc.depositar(100);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			cc.transferir(100, poupanca);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();*/
		String nome;
	    int cpf;
	    double deposito = 100;
	    double transfere = 20;
		Banco banco = new Banco("Banrisul");
		System.out.println("***** Banco "+banco.getNome()+" *****");
		System.out.println("      ==============\n");
		
		for(int i = 1; i < 4; i++) {
			nome = "Mauro "+i+":";
		    cpf = 123456789;
		    cpf += i;
		    Cliente mauro = new Cliente(nome, cpf);
			Conta cc = new ContaCorrente(mauro);
			banco.addContaNaLista(cc);
		    Conta poupanca = new ContaPoupanca(mauro);
		    banco.addContaNaLista(poupanca);
		    //DEPOSITAR
		    try {
		    	//deposito += i;
				cc.depositar(deposito + i);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		    //transferir
			try {
				//transfere += i;
				cc.transferir(transfere + 1, poupanca);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("=== LISTA DAS CONTAS CRIADAS ===");
		System.out.println("    ------------------------");
		/*for (Conta conta : banco.relacaoContaPorCliente()) {
		      conta.imprimirExtrato();
		}*/
		double totalSaldo = banco.calcularValorSaldosTotal();
		System.out.println("O total de todo o saldo: "+totalSaldo);
		System.out.println("Obtendo a conta de saldo com maior valor:");
		System.out.println("-----------------------------------------");
		Conta saldoMaiorValor = banco.obterSaldoDeMaiorValor();
		saldoMaiorValor.imprimirExtrato();
		
		System.out.println("Relacao de contas por Numero:");
		System.out.println("=============================");
		
		for (Conta conta : banco.relacaoContasPorNumero()) {
		      conta.imprimirExtrato();
		}
		System.out.println("Relacao de contas por SALDO:");
		System.out.println("----------------------------");
		for (Conta conta : banco.relacaoContasPorSaldo()) {
		      conta.imprimirExtrato();
		}
	}
}
