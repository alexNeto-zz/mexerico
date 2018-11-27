package com.chatter.commander;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import com.chatter.servidor.Servidor;

public class Commander {

	private CommandLine commander = null;
	private Options options = null;

	public Commander() {
		options = new Options();
	}

	public Options getOptions() {
		options.addOption(OptionsEnum.EXAMPLE.option, false, "display current time");
		options.addOption(OptionsEnum.COMECA_SERVIDOR.option, false, "Inicia o servidor");
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

	}

	private void iniciaServidor() {
		try {
			Servidor servidor = new Servidor(12345);
			servidor.abreServidor();
		} catch (Exception ignored) {
			System.out.println("Não foi possível estabelecer uma conexão");
		}
	}
}
