package br.com.kaio.mapper.modelo;

import java.math.BigDecimal;

public class Transacao {

	private BigDecimal amount;
	private Long cod;
	private String sos;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
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
		return "Transacao [amount=" + amount + ", cod=" + cod + ", sos=" + sos + "]";
	}
}
