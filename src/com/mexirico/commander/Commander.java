package com.mexirico.commander;

import static com.mexirico.commander.Estilista.coloreTexto;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import com.mexirico.cliente.Cliente;
import com.mexirico.servidor.Servidor;

public class Commander {

	private CommandLine commander = null;
	private Options options = null;

	public Commander() {
		options = new Options();
	}

	public Options getOptions() {
		options.addOption(OptionsEnum.EXAMPLE.option, false, "display current time");
		options.addOption(OptionsEnum.COMECA_CLIENTE.option, true, "Inicia o Cliente");
		options.addOption(OptionsEnum.COMECA_SERVIDOR.option, false, "Inicia o servidor");
		options.addOption(OptionsEnum.NOME.option, true, "Define nome para usuario");
		return options;
	}

	public CommandLine execute(String[] args) {

		try {
			CommandLineParser parser = new DefaultParser();
			commander = parser.parse(getOptions(), args);
			commandManager();
		} catch (Exception e) {
			System.exit(1);
		}
		return commander;
	}

	public void commandManager() throws Exception {
		if (commander.hasOption(OptionsEnum.COMECA_SERVIDOR.option)) {
			iniciaServidor();
		}
		if (commander.hasOption(OptionsEnum.COMECA_CLIENTE.option)) {
			iniciaCliente(commander.getOptionValue(OptionsEnum.COMECA_CLIENTE.option),
					pegaNome(commander.getOptionValue(OptionsEnum.NOME.option)));
		}

	}

	private String pegaNome(String nome) {
		return nome != null ? coloreTexto(nome, CoresEnum.VERDE) : coloreTexto("anon", CoresEnum.VERMELHO) + ": ";
	}

	private void iniciaCliente(String host, String nomeUsuario) {
		try {
			Cliente cliente = new Cliente(host, 9009, nomeUsuario);
			System.out.println(host);
			cliente.conectar();
		} catch (Exception ignores) {
			System.out.println("Não foi possível estabelecer conexão com o cliente");
		}
	}

	private void iniciaServidor() {
		try {
			Servidor servidor = new Servidor(9009);
			servidor.abreServidor();
		} catch (Exception ignored) {
			System.out.println("Não foi possível estabelecer uma conexão");
		}
	}
}
