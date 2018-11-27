package com.mexerico.commander;

public class Estilista {

	public static String reinicia() {
		return "\u001B[0m";
	}

	public static String coloreTexto(String texto, CoresEnum cor) {
		return cor.cor + texto + cor.cor + reinicia();
	}
}
