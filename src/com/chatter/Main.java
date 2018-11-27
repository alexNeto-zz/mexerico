package com.chatter;

import com.chatter.commander.Commander;

public class Main {

	public static void main(String[] args) {
		Commander commander = new Commander();
		commander.execute(args);
	}

}
