package br.com.kaio.mapper.factory.model;

import br.com.kaio.mapper.factory.IReplyCommand;

public class Pessoa implements IReplyCommand{

	private String c_PESSOA = "01";

    private String m_value;
    private String m_responseCode;
    private Integer m_commandLlength;

    @Override
    public void setCommandValue(String value)
    {
        m_value = value;
    }


    @Override
    public void parse() {

        if (m_responseCode.equals(c_PESSOA)) {
            m_commandLlength = Integer.valueOf(m_value.substring(0, 2));

        }
    }

    @Override
    public void setResponseCode(String value) {
        m_responseCode = value;
    }

	@Override
	public String toString() {
		return "Pessoa [c_PESSOA=" + c_PESSOA + ", m_value=" + m_value + ", m_responseCode="
				+ m_responseCode + ", m_commandLlength=" + m_commandLlength + "]";
	}

}
