package com.chatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Cliente {

	private Socket socket;
	private OutputStream ou;
	private Writer ouw;
	private BufferedWriter bfw;

	public void conectar() throws IOException {

		socket = new Socket("ip", Integer.parseInt("port"));
		ou = socket.getOutputStream();
		ouw = new OutputStreamWriter(ou);
		bfw = new BufferedWriter(ouw);
		bfw.write("");
		bfw.flush();
	}

	public void enviarMensagem(String msg) throws IOException {

		if (msg.equals("Sair")) {
			bfw.write("Desconectado \r\n");
			// texto.append("Desconectado \r\n");
		} else {
			bfw.write(msg + "\r\n");
			// texto.append(txtNome.getText() + " diz -> " + txtMsg.getText() + "\r\n");
		}
		bfw.flush();
		// txtMsg.setText("");
	}

	public void escutar() throws IOException {

		InputStream in = socket.getInputStream();
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader bfr = new BufferedReader(inr);
		String msg = "";

		while (!"Sair".equalsIgnoreCase(msg))

			if (bfr.ready()) {
				msg = bfr.readLine();
				if (msg.equals("Sair"))
					System.out.println("Servidor caiu! \\r\\n");
				else
					System.out.println(msg + "\r\n");
			}
	}

	public void sair() throws IOException {

		enviarMensagem("Sair");
		bfw.close();
		ouw.close();
		ou.close();
		socket.close();
	}
}
