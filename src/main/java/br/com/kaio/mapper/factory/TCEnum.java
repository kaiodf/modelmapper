package br.com.kaio.mapper.factory;

import java.util.Arrays;

import br.com.kaio.mapper.factory.model.Funcionario;
import br.com.kaio.mapper.factory.model.Pessoa;

public enum TCEnum {

	SALES_DRAFT_05("05"){
		@Override
		public IReplyCommand create() {
			return new Pessoa();
		}
	},
    CREDIT_VOUCHER_06("06"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    CASH_DISBURSEMENT_07("07"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    CHARGEBACK_SALES_DRAFT_15("15"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    CHARGEBACK_CREDIT_VOUCHER_16("16"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    CHARGEBACK_CASH_DISBURSEMENT_17("17"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    REVERSAL_SALES_DRAFT_25("25"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    REVERSAL_CREDIT_VOUCHER_26("26"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    REVERSAL_CASH_DISBURSEMENT_27("27"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    HEADER_90("90"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    BATCH_TRAILER_91("91"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	},
    FILE_TRAILER_92("92"){
		@Override
		public IReplyCommand create() {
			return new Funcionario();
		}
	};

    private final String number;
    
    public abstract IReplyCommand create();

    private TCEnum(final String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public static TCEnum getByNumber(final String number) {
        return Arrays.asList(TCEnum.values())
                .stream()
                .filter(t -> t.getNumber().equals(number))
                .findFirst().orElse(null);
    }
}
