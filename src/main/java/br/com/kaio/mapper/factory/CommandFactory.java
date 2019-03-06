package br.com.kaio.mapper.factory;

public class CommandFactory {

	public static IReplyCommand parseCommand(String value)
    {
        return TCEnum.valueOf(TCEnum.getByNumber(value.substring(0,2)).toString()).create();
    }

}
