package br.com.kaio.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import br.com.kaio.mapper.dto.TransacaoDto;
import br.com.kaio.mapper.modelo.Transacao;

public class TransacaoTest {

	private ModelMapper mapper;
	private Map<Long,Long> currency;

	@Before
	public void setup() {
		this.mapper = new ModelMapper();
		this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	}
	
	@Test
	public void sub() {
		String x = "0001000";
		String value = x.substring(2);
		String scale = x.substring(0,2);
		BigDecimal amount = new BigDecimal(new BigInteger(value),Integer.valueOf(scale));
		System.out.println(amount.toString());
	}
	
//	@Test
	public void calcularValor() {
		List<TransacaoDto> dtos = loadDtos();
//		Converter<TransacaoDto, Transacao> converter = new AbstractConverter<TransacaoDto, Transacao>(){
//
//			@Override
//			protected Transacao convert(TransacaoDto source) {
//				Transacao destination = new Transacao();
//				if(!StringUtils.isBlank(source.getCod())) {
//					destination.setCod(Long.valueOf(source.getCod()));
//				}
//				
//				destination.setAmount(verifyCod(source));
//				
//				destination.setSos(source.getSos());
//				
//				return destination;
//			}
//
//		};
//		
//		mapper.addConverter(converter);
		
		
		for (TransacaoDto dto : dtos) {
			Transacao transacao = mapper.map(dto, Transacao.class);
			transacao.setAmount(changeToCurrency(dto, transacao.getAmount()));
			
			System.out.println(transacao);
		}
	}
	
	private BigDecimal verifyCod(TransacaoDto source) {
		BigDecimal amount = BigDecimal.ZERO;
		amount = changeToCurrency(source, amount);
		return amount;
	}

	private BigDecimal changeToCurrency(TransacaoDto source, BigDecimal amount) {
		loadCurrency();
		amount = new BigDecimal(new BigInteger(source.getAmount()),currency.get(new Long(source.getCod())).intValue());
		return amount;
	}
	
	private Map<Long,Long> loadCurrency(){
		currency = new HashMap<Long,Long>();
		currency.put(new Long(392), new Long(0));
		currency.put(new Long(600), new Long(1));
		currency.put(new Long(986), new Long(2));
		return currency;
	}
	
	private List<TransacaoDto> loadDtos() {
		List<TransacaoDto> list = new ArrayList<TransacaoDto>();
		list.add(loadTransacaoDto("600","000000015440","1"));
		list.add(loadTransacaoDto("392", "000000005500","2"));
		list.add(loadTransacaoDto("986", "000000550000","3"));
		list.add(loadTransacaoDto("986", "000000000003","4"));
		return list; 
	}

	private TransacaoDto loadTransacaoDto(String cod, String amount, String sos) {
		TransacaoDto dto = new TransacaoDto();
		dto.setCod(cod);
		dto.setAmount(amount);
		dto.setSos(sos);
		return dto;
	}
	
}
