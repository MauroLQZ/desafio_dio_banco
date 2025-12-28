package desafio_dio_banco.banco_online;

public interface IConta {
	
	void sacar(double valor) throws RuntimeException;   
	void depositar(double valor) throws RuntimeException;
	void transferir(double valor, IConta contaDestino) throws RuntimeException;
	void imprimirExtrato();
}
