package br.com.kaio.mapper.factory;

public class AppX {
	
	public static void main(String[] args) {
		System.out.println(CommandFactory.parseCommand("05"));
//		System.out.println(TCEnum.valueOf(TCEnum.getByNumber("05").toString()).create());
//		System.out.println(TCEnum.valueOf(TCEnum.getByNumber("05").toString()).create());
//		System.out.println(TCEnum.valueOf(TCEnum.getByNumber("90").toString()).create());
	}

}
