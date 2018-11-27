package com.mexerico.cliente;

import java.io.InputStream;
import java.util.Scanner;

public class Atualizador implements Runnable {

	private final InputStream mensagens;

	public Atualizador(InputStream mensagens) {

		this.mensagens = mensagens;
	}

	public void run() {
		try (Scanner leitor = new Scanner(mensagens)) {
			while (leitor.hasNextLine()) {
				System.out.println(leitor.nextLine());
			}
		}
	}
}