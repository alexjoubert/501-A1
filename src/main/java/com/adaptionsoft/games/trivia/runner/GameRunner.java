
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game(new Random());
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		
		aGame.run();
		
	}
}
