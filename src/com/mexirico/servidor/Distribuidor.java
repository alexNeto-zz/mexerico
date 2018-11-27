package com.mexirico.servidor;

import java.io.InputStream;
import java.util.Scanner;

public class Distribuidor implements Runnable {

	private InputStream mensagens; // Recebe a entrada de mensagens via InputStream.
	private Servidor servidor; // Recebe a referência do servidor que está ativo.

	public Distribuidor(InputStream mensagens, Servidor servidor) {

		this.mensagens = mensagens;
		this.servidor = servidor;

	}

	public void run() {

		Scanner leitor = new Scanner(this.mensagens);

		while (leitor.hasNextLine()) {
			servidor.distribuiMensagens(leitor.nextLine());
		}

		leitor.close();
	}
}