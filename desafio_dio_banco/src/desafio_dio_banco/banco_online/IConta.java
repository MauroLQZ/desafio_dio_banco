package desafio_dio_banco.banco_online;

public interface IConta {
	
	void sacar(double valor);   
	void depositar(double valor);
	void transferir(double valor, IConta contaDestino);
	void imprimirExtrato();
}
