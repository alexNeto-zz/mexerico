package com.chatter.commander;

public enum OptionsEnum {

	EXAMPLE("t"),
	COMECA_CLIENTE("c"),
	COMECA_SERVIDOR("s");

	public String option;

	OptionsEnum(String option) {
		this.option = option;
	}

}
