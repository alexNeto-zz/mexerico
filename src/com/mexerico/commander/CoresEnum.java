package com.mexerico.commander;

public enum CoresEnum {

	VERMELHO("\u001B[31m"), 
	VERDE("\u001B[32m"), 
	AMARELO("\u001B[33m"), 
	AZUL("\u001B[34m"),
	ROXO("\u001B[35m"),
	ANIL("\u001B[36m"), 
	BRANCO("\u001B[37m");

	public String cor;

	CoresEnum(String cor) {
		this.cor = cor;
	}

}
