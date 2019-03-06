package br.com.kaio.mapper;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import br.com.kaio.mapper.dto.PedidoDto;
import br.com.kaio.mapper.modelo.Cliente;
import br.com.kaio.mapper.modelo.Endereco;
import br.com.kaio.mapper.modelo.Nome;
import br.com.kaio.mapper.modelo.Pedido;
import br.com.kaio.mapper.modelo.PedidoFlat;
import br.com.kaio.mapper.modelo.Produto;
import junit.framework.Assert;


public class ModelMapperFrameworkTest {
	
	private ModelMapper mapper;

	@Before
	public void setup() {
		this.mapper = new ModelMapper();
		this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	}
	
	@Test
	public void testMapperCreatesDtoFromFlatDomainObject() {
		
		PedidoFlat pedidoFlat = geraPedidoFlat();

		System.out.println(pedidoFlat);

		Converter<PedidoFlat,PedidoDto> converter = new AbstractConverter<PedidoFlat,PedidoDto>(){

			@Override
			protected PedidoDto convert(PedidoFlat source) {
				PedidoDto destination = new PedidoDto();
				destination.setCepDestino(source.getCep());
				destination.setCidadeDestino(source.getCidade());
				
				if("nome".equalsIgnoreCase(source.getNomeCliente()))
					destination.setCliente(source.getNomeCliente().toUpperCase() + " - "+ source.getCidade());
				
				destination.setNumeroDestino(String.valueOf(source.getNumero()));
				destination.setRuaDestino(source.getRua());

		        return destination;
		    }
			
		};
		
		mapper.addConverter(converter);
		
		PedidoDto dto = mapper.map(pedidoFlat, PedidoDto.class);
		
		System.out.println(dto);
		
		Assert.assertEquals(pedidoFlat.getRua(), dto.getRuaDestino());
		Assert.assertEquals(pedidoFlat.getCidade(), dto.getCidadeDestino());
		Assert.assertEquals(pedidoFlat.getCep(), dto.getCepDestino());
		Assert.assertEquals(pedidoFlat.getNomeCliente(), dto.getCliente());
	}

	
	@Test
	public void testMapperCreatesDomainObjectFromDto() {
		
		PedidoDto dto = geraPedidoDto();
		
		PedidoFlat pedidoFlat = mapper.map(dto, PedidoFlat.class);
		
		Assert.assertEquals(pedidoFlat.getNomeCliente(),dto.getCliente());
		Assert.assertEquals(pedidoFlat.getRua(),dto.getRuaDestino());
		Assert.assertEquals(String.valueOf(pedidoFlat.getNumero()), dto.getNumeroDestino());
		Assert.assertEquals(pedidoFlat.getCidade(),dto.getCidadeDestino());
		Assert.assertEquals(pedidoFlat.getCep(),dto.getCepDestino());
	}

	@Test
	public void testMapperCreatesDtoFromDeepObjectGraph() {
		
		Pedido pedido = geraPedido();
		
		mapper.addMappings(new PropertyMap<Pedido, PedidoDto>() {

			@Override
			protected void configure() {
				map().setCliente(source.getCliente().getNome().getPrimeiroNome());
			}
		});

		PedidoDto dto = mapper.map(pedido, PedidoDto.class);
		
		
		Assert.assertEquals(pedido.getDestino().getNumero(), String.valueOf(dto.getNumeroDestino()));
		Assert.assertEquals(pedido.getDestino().getRua(), dto.getRuaDestino());
		Assert.assertEquals(pedido.getDestino().getCidade(), dto.getCidadeDestino());
		Assert.assertEquals(pedido.getDestino().getCep(), dto.getCepDestino());
		Assert.assertEquals(pedido.getCliente().getNome().getPrimeiroNome(), dto.getCliente());
		Assert.assertEquals(pedido.getProdutos().size(), dto.getProdutos().size());
		Assert.assertEquals(pedido.getProdutos().get(0).getCodigo(), dto.getProdutos().get(0).getCodigo());
	}

	private Pedido geraPedido() {
		
		Cliente cliente = clienteNico();
		Endereco destino = naRuaBuarqueDeMacedo();
		
		Pedido pedido = new Pedido(cliente, destino);
		Produto produto = new  Produto("iphone", "223344");
		pedido.adicionaProduto(produto);
		
		return pedido;
	}
	

	private PedidoDto geraPedidoDto() {
		
		PedidoDto dto = new PedidoDto();
		dto.setCliente("Jo??o");
		dto.setRuaDestino("Catete");
		dto.setNumeroDestino("50");
		dto.setCidadeDestino("Rio");
		dto.setCepDestino("20040-030");
		return dto;
	}

	private PedidoFlat geraPedidoFlat() {
		PedidoFlat pedidoFlat = new PedidoFlat();
		pedidoFlat.setCep("20040-030");
		pedidoFlat.setCidade("Rio");
		pedidoFlat.setNomeCliente("Nome");
		pedidoFlat.setRua("Catete");
		return pedidoFlat;
	}

	private Cliente clienteNico() {
		Endereco endereco = new Endereco().
		comCep("20040-030").
		comCidade("Rio de Janeiro").
		comNumero("50").
		comRua("Rua do Ouvidor");

		return new Cliente(new Nome("Nico", "Steppat"), endereco);
	}

	private Endereco naRuaBuarqueDeMacedo() {
		Endereco endereco = new Endereco().
		comCep("22220-030").
		comCidade("Rio de Janeiro").
		comNumero("50").
		comRua("Rua Buarque de Macedo");
		
		return endereco;
	}
}
