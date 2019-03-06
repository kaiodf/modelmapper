package br.com.kaio.teste;

import java.math.BigDecimal;

public class AppBigDecimal {
	
	public String convertValue(BigDecimal amount, String code) {
//		Integer scale = parserUtil.getScale(code);
		Integer scale = verifiCode(code);
		for(int i=0;i<scale.intValue();i++) {
			amount = amount.multiply(BigDecimal.TEN);
		}
		return String.valueOf(amount.longValue());
	}

	private Integer verifiCode(String code) {
		if("840".equalsIgnoreCase(code)) {
			return 2;
		}else if("600".equalsIgnoreCase(code)) {
			return 3;
		}
		return null;
	}

	public static void main(String[] args) {
		AppBigDecimal app = new AppBigDecimal();
		System.out.println(app.convertValue(new BigDecimal("0.100"), "840"));
	}
}
