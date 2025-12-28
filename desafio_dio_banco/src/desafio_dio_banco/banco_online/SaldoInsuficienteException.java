package desafio_dio_banco.banco_online;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(double valor) {
		super("Saldo insufuciente para sacar o valor de: "+valor);
	}
}
