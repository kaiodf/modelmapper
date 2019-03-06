package br.com.kaio.mapper.dto;

public class ProdutoDto {
	
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "ProdutoDto [codigo=" + codigo + "]";
	}
	
	

}
