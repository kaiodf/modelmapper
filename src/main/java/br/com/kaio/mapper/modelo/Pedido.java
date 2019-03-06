package br.com.kaio.mapper.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<Produto>();
	private Endereco destino;
	
	public Pedido(Cliente cliente, Endereco destino) {
		this.cliente = cliente;
		this.destino = destino;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public Endereco getDestino() {
		return destino;
	}

	public void adicionaProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		return "Pedido [cliente=" + cliente + ", produtos=" + produtos + ", destino=" + destino + "]";
	}
	
}
