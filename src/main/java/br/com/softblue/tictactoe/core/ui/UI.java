package br.com.softblue.tictactoe.core.ui;

import br.com.softblue.commons.io.Console;

public class UI {
	
	public static void printText(String text){
		System.out.println(text);
	}
	public static void printTextWithNoNewLine(String string) {
		System.out.print(string);
	}
	public static void printNewLine() {
		System.out.println();
	}
	
	public static void printGameTitle() {
		printText("==================");
		printText("| JOGO DA VELHA  |");
		printText("==================");
	}
	public static String readImput(String text) {
		printTextWithNoNewLine(text + " ");
		return Console.readString();
		
	}

}
