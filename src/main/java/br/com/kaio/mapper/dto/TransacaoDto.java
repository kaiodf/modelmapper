package br.com.kaio.mapper.dto;

public class TransacaoDto {

	private String amount;
	private String cod;
	private String sos;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	public String getSos() {
		return sos;
	}
	public void setSos(String sos) {
		this.sos = sos;
	}
	@Override
	public String toString() {
		return "TransacaoDto [amount=" + amount + ", cod=" + cod + ", sos=" + sos + "]";
	}
}
