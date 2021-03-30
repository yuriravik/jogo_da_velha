package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.core.ui.UI;

public class Player {
	
	private String name;
	private Board board;
	private char symbol;
	
	
	public Player(String name, Board board, char symbol) {
		super();
		this.name = name;
		this.board = board;
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public Board getBoard() {
		return board;
	}
	public char getSymbol() {
		return symbol;
	}
	
	private Move inputMove() throws InvalidMoveException {
		String moveStr = UI.readImput("jogador '" + name + "'=>");
		return new Move(moveStr);
	}
	public boolean play() throws InvalidMoveException  {
		Move move = inputMove();
		return board.play(this, move);
	}

}
