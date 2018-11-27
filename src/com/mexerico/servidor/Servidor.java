package com.mexerico.servidor;

import static com.mexerico.commander.Estilista.coloreTexto;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.mexerico.commander.CoresEnum;

public class Servidor {

	private final int porta;
	private final List<PrintStream> clientes; // Guarda os clientes que se conectarem ao servidor.

	public Servidor(int porta) {

		this.porta = porta;
		this.clientes = new ArrayList<>();

	}

	public void abreServidor() throws IOException {
		try (ServerSocket servidor = new ServerSocket(this.porta)) {
			System.out.println(
					"Servidor na porta " + coloreTexto(Integer.toString(this.porta), CoresEnum.VERMELHO) + " aberto!");

			while (true) {
				Socket cliente = servidor.accept(); // Aceita a conexão com o cliente.
				System.out.println("Conexão com o cliente " + cliente.getInetAddress().getHostAddress()
						+ " estabilizada com sucesso!");

				PrintStream caminho_mensagens = new PrintStream(cliente.getOutputStream());
				this.clientes.add(caminho_mensagens); // Guarda o OutputStream de todos os clientes que se conectam.

				Distribuidor distribuidor = new Distribuidor(cliente.getInputStream(), this);
				new Thread(distribuidor).start(); // Inicia uma thread de Distribuidor para espalhar as mensagens.
			}
		}
	}

	public void distribuiMensagens(String mensagem) {
		for (PrintStream cliente : this.clientes) {
			cliente.println(mensagem);
		}
	}
}