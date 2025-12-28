package desafio_dio_banco.banco_online;

public class Cliente {  
	private String nome;
	private int cpf;
	
	public Cliente(String nome, int cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return this.cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
}
