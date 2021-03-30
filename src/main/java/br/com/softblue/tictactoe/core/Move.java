package br.com.softblue.tictactoe.core;

public class Move {
	
	private int j;
	private int i;
	
	public Move(String moveStr)throws InvalidMoveException {
		try {
		String[] tokens = moveStr.split(",");
		
		this.i = Integer.parseInt(tokens[0]);
		this.j = Integer.parseInt(tokens[1]);
		}catch (Exception e){
			throw new InvalidMoveException("a jogada é invalida");
			
		}
	}
	
	public int getJ() {
		return j;
	}
	public int getI() {
		return i;
	}
	
}