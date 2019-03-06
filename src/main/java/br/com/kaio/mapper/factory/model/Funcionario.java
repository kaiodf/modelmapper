package br.com.kaio.mapper.factory.model;

import br.com.kaio.mapper.factory.IReplyCommand;

public class Funcionario implements IReplyCommand{

	private String c_FUNCIONARIO = "01";

    private String m_value;
    private String m_header;
    private String m_responseCode;
    private Integer m_commandLlength;

    @Override
    public void setCommandValue(String value)
    {
        m_value = value;
    }

    @Override
    public void parse() {

        if (m_responseCode.equals(c_FUNCIONARIO)) {

        }
    }

    @Override
    public void setResponseCode(String value) {
        m_responseCode = value;
    }

	@Override
	public String toString() {
		return "Funcionario [c_FUNCIONARIO=" + c_FUNCIONARIO + ", m_value=" + m_value + ", m_header=" + m_header
				+ ", m_responseCode=" + m_responseCode + ", m_commandLlength=" + m_commandLlength + "]";
	}

    
}
