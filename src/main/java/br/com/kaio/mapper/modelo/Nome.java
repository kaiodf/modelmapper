package br.com.kaio.mapper.modelo;

public class Nome {

	private String sobreNome;
	private String primeiroNome;

	public Nome(String primeiroNome, String sobreNome) {
		this.primeiroNome = primeiroNome;
		this.sobreNome = sobreNome;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	@Override
	public String toString() {
		return "Nome [sobreNome=" + sobreNome + ", primeiroNome=" + primeiroNome + "]";
	}


}
