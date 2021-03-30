package br.com.softblue.tictactoe.core;

import java.io.IOException;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.core.ui.UI;
import br.com.softblue.tictactoe.score.FileScoreManeger;
import br.com.softblue.tictactoe.score.ScoreManeger;

public class Game {
	
private	Board board = new Board();
private	Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];
private int currentPlayerIndex = -1;
private ScoreManeger scoreManeger;

	
	
	
		public void play() throws IOException {
			scoreManeger = createScoreManeger();
			
			
			UI.printGameTitle();
			
			
			for (int i = 0; i < players.length; i++) {
				players[i] = createPlayer(i);
			}
			
			boolean gameEnded = false;
			Player currentPlayer = nextPlayer();
			Player winner = null;
			
			while(!gameEnded) {
				board.print();
				
				boolean sequenceFound;
				try {
					sequenceFound = currentPlayer.play();
				} catch(InvalidMoveException e) {
					UI.printText("erro:" + e.getMessage());
					continue;
				}
				if (sequenceFound) {
					gameEnded = true;
					winner = currentPlayer;
					
				} else if(board.isfull()) {	
					gameEnded = true;
				}
				else {
					currentPlayer = nextPlayer();
				}
			}
			
			if (winner == null) {
				UI.printText("o jogo terminou empatado");
				
			} else {
				UI.printText("o jogador'" + winner.getName()+ "' venceu o jogo!");
			
				scoreManeger.saveScore(winner);
				
			}
			
			board.print();
			UI.printText("fim do jogo");
		}
		private Player createPlayer(int index) {
			String name = UI.readImput("Jogador" + (index + 1) + "=>");
			char symbol = Constantes.SYMBOL_PLAYERS[index];
			Player player = new Player(name,board,symbol);
			
			Integer score = scoreManeger.getScore(player);
			
			if(score != null) {
				UI.printText("o jogador'" + player.getName()+ " ja possi "+ score + "vitoria(s)!");
				
			}
			UI.printText("O Jogador '" + name +"' VAI USAR O SIMBOLO'" + Constantes.SYMBOL_PLAYERS[index] +"'");
			
			return player;
		}
		private Player nextPlayer() {
			
		/*	currentPlayerIndex++;
			
			if (currentPlayerIndex >= players.length) {
				currentPlayerIndex = 0;
			}
			return players[currentPlayerIndex ];*/
			
			currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
			return players[currentPlayerIndex];
		}
		private ScoreManeger createScoreManeger()throws IOException {
			return new FileScoreManeger();
			
		}
		
		}

