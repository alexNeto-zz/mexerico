package com.mexerico.commander;

public enum OptionsEnum {

	EXAMPLE("t"),
	COMECA_CLIENTE("c"),
	COMECA_SERVIDOR("s"),
	NOME("n");

	public String option;

	OptionsEnum(String option) {
		this.option = option;
	}

}
