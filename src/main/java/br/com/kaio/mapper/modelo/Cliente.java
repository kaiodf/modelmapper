package br.com.kaio.mapper.modelo;

public class Cliente {

	private Nome nome;
	private Endereco endereco;

	public Cliente(Nome nome, Endereco endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Nome getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + "]";
	}

}
