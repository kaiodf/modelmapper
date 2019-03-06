package br.com.kaio.mapper.factory;

import br.com.kaio.mapper.factory.model.Funcionario;
import br.com.kaio.mapper.factory.model.Pessoa;

public enum CommandTypes {

	C1
	{
		@Override
        public IReplyCommand getCommand(String value){
            return super.parseBase(new Funcionario(), value);
		}
	},
	C2
	{
		@Override
        public IReplyCommand getCommand(String value){
            return super.parseBase(new Pessoa(), value);
		}
	};

    public abstract IReplyCommand getCommand(String value);

    private IReplyCommand parseBase(IReplyCommand instance, String value)
    {
        instance.setResponseCode(value.substring(0,2));
        instance.setCommandValue(value.substring(2));
        instance.parse();

        return instance;
    }
}
