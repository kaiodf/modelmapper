package br.com.kaio.mapper.factory;

public interface IReplyCommand {

	void setCommandValue(String value);
	void setResponseCode(String value);
    void parse();
}
