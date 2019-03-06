package br.com.kaio.mapper.serializer;

import java.math.BigDecimal;

import org.jsefa.flr.annotation.FlrDataType;
import org.jsefa.flr.annotation.FlrField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@FlrDataType
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class M1 {

	@FlrField(pos = 1, length =2)
	Integer id;
	
	@FlrField(pos = 3, length =10)
	String nome;

	@FlrField(pos = 4, length =9)
	String apelido;
	
	@FlrField(pos = 5, length =3)
	String cargo;
	
	@FlrField(pos = 6, length =3)
	BigDecimal salario;

	@Override
	public String toString() {
		return "M1 [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", cargo=" + cargo + ", salario=" + salario
				+ "]";
	}
}
