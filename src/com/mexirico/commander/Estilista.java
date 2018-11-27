package com.mexirico.commander;

public class Estilista {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public String reinicia() {
		return "\u001B[0m";
	}

	public String coloreTexto(String texto, CoresEnum cor) {
		return cor.cor + texto + cor.cor;
	}
}
