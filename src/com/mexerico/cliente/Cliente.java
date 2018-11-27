package com.mexerico.cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private final String host;
	private final int porta;
	private Socket cliente;
	private String nomeUsuario;

	public Cliente(String host, int porta, String nomeUsuario) {

		this.host = host;
		this.porta = porta;
		this.nomeUsuario = nomeUsuario;

	}

	public void conectar() throws IOException {
		this.cliente = new Socket(this.host, this.porta);
		System.out.println("O cliente conseguiu se conectar ao servidor!");
		new Thread(new Ouvidor(getClienteInputStream())).start();
		try (Scanner teclado = new Scanner(System.in)) {
			PrintStream saida = new PrintStream(this.getClienteOutputStream());

			while (teclado.hasNextLine()) {
				saida.println(nomeUsuario + teclado.nextLine());
				System.out.print(String.format("\033[%dA", 1));
				System.out.print("\033[2K");
			}
		}
	}

	public OutputStream getClienteOutputStream() throws IOException {
		return cliente.getOutputStream();
	}

	public InputStream getClienteInputStream() throws IOException {
		return cliente.getInputStream();
	}

}