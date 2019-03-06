package br.com.kaio.mapper;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

public class ModelMapperExample {

    @Test
    public void test() {

        final ModelMapper modelMapper = new ModelMapper();

        final Converter<String, BigDecimal> converter = new Converter<String, BigDecimal>() {

            public BigDecimal convert(MappingContext<String, BigDecimal> context) {
                OutroExemplo outroExemplo = (OutroExemplo) context.getParent().getSource();

                if ("XXX".equals(outroExemplo.codigoMoeda)) {
                    return BigDecimal.valueOf(Long.parseLong(outroExemplo.valor), outroExemplo.decimais);
                }
                return new BigDecimal(context.getSource());
            }
        };

        modelMapper.addConverter(converter);

        modelMapper //
                .getConfiguration() //
                .setAmbiguityIgnored(true) //
                .setFieldAccessLevel(AccessLevel.PRIVATE) //
//                .setSkipNullEnabled(Boolean.TRUE) //
                .setMatchingStrategy(MatchingStrategies.STRICT);

        final OutroExemplo outroExemplo = new OutroExemplo();
        outroExemplo.codigoMoeda = "XXX";
        outroExemplo.valor = "00000010000";
        outroExemplo.decimais = 3;

        final Exemplo exemplo = modelMapper.map(outroExemplo, Exemplo.class);

        System.out.println(exemplo);
        
        Assert.assertEquals(BigDecimal.valueOf(10000, 3), exemplo.valor);
    }

    public static class Exemplo {
        private BigDecimal valor;
        private String txt;

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }
        
        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
        	return "valor: "+this.valor + " txt: "+this.txt;
        }
    }

    public static class OutroExemplo {
        private String valor;
        private String codigoMoeda;
        private Integer decimais;

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public String getCodigoMoeda() {
            return codigoMoeda;
        }

        public void setCodigoMoeda(String codigoMoeda) {
            this.codigoMoeda = codigoMoeda;
        }

        public Integer getDecimais() {
            return decimais;
        }

        public void setDecimais(Integer decimais) {
            this.decimais = decimais;
        }
        @Override
        public String toString() {
        	return "valor: "+ valor+ " codigoMoeda: "+codigoMoeda+ " decimais:"+decimais;
        }
    }
}
