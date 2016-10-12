package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class CharacterizationTest {
	
		private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	     @Before
	     public void setUp() {
	    	 System.setOut(new PrintStream(outContent));
	     }
	 
	     @After
	     public void tearDown() {
	         System.setOut(null);
	     }
	 
	     @Test
	     public void rollCharacterizationForRollResult5() {
	         Game aGame = new Game(new Random(1234));
	         aGame.add("Chet");
	         aGame.add("Pat");
	         aGame.add("Sue");
	 
	         aGame.run();
	 
	         assertEquals(expectedOutput(), outContent.toString());
	     }
	 
	     // Test fails yet failure trace has no difference
	     private String expectedOutput() {
	         String expectedOutput = "Chet was added\n";
	         expectedOutput += "They are player number 1\n";
	         expectedOutput += "Pat was added\n";
	         expectedOutput += "They are player number 2\n";
	         expectedOutput += "Sue was added\n";
	         expectedOutput += "They are player number 3\n";
	         expectedOutput += "Chet is the current player\n";
	         expectedOutput += "They have rolled a 4\n";
	         expectedOutput += "Chet's new location is 4\n";
	         expectedOutput += "The category is Pop\n";
	         expectedOutput += "Pop Question 0\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Chet now has 1 Gold Coins.\n";
	         expectedOutput += "Pat is the current player\n";
	         expectedOutput += "They have rolled a 4\n";
	         expectedOutput += "Pat's new location is 4\n";
	         expectedOutput += "The category is Pop\n";
	         expectedOutput += "Pop Question 1\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Pat now has 1 Gold Coins.\n";
	         expectedOutput += "Sue is the current player\n";
	         expectedOutput += "They have rolled a 1\n";
	         expectedOutput += "Sue's new location is 1\n";
	         expectedOutput += "The category is Science\n";
	         expectedOutput += "Science Question 0\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Sue now has 1 Gold Coins.\n";
	         expectedOutput += "Chet is the current player\n";
	         expectedOutput += "They have rolled a 5\n";
	         expectedOutput += "Chet's new location is 9\n";
	         expectedOutput += "The category is Science\n";
	         expectedOutput += "Science Question 1\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Chet now has 2 Gold Coins.\n";
	         expectedOutput += "Pat is the current player\n";
	         expectedOutput += "They have rolled a 3\n";
	         expectedOutput += "Pat's new location is 7\n";
	         expectedOutput += "The category is Rock\n";
	         expectedOutput += "Rock Question 0\n";
	         expectedOutput += "Question was incorrectly answered\n";
	         expectedOutput += "Pat was sent to the penalty box\n";
	         expectedOutput += "Sue is the current player\n";
	         expectedOutput += "They have rolled a 1\n";
	         expectedOutput += "Sue's new location is 2\n";
	         expectedOutput += "The category is Sports\n";
	         expectedOutput += "Sports Question 0\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Sue now has 2 Gold Coins.\n";
	         expectedOutput += "Chet is the current player\n";
	         expectedOutput += "They have rolled a 3\n";
	         expectedOutput += "Chet's new location is 0\n";
	         expectedOutput += "The category is Pop\n";
	         expectedOutput += "Pop Question 2\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Chet now has 3 Gold Coins.\n";
	         expectedOutput += "Pat is the current player\n";
	         expectedOutput += "They have rolled a 5\n";
	         expectedOutput += "Pat is getting out of the penalty box\n";
	         expectedOutput += "Pat's new location is 0\n";
	         expectedOutput += "The category is Pop\n";
	         expectedOutput += "Pop Question 3\n";
	         expectedOutput += "Answer was correct!!!!\n";
	         expectedOutput += "Pat now has 2 Gold Coins.\n";
	         expectedOutput += "Sue is the current player\n";
	         expectedOutput += "They have rolled a 1\n";
	         expectedOutput += "Sue's new location is 3\n";
	         expectedOutput += "The category is Rock\n";
	         expectedOutput += "Rock Question 1\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Sue now has 3 Gold Coins.\n";
	         expectedOutput += "Chet is the current player\n";
	         expectedOutput += "They have rolled a 3\n";
	         expectedOutput += "Chet's new location is 3\n";
	         expectedOutput += "The category is Rock\n";
	         expectedOutput += "Rock Question 2\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Chet now has 4 Gold Coins.\n";
	         expectedOutput += "Pat is the current player\n";
	         expectedOutput += "They have rolled a 5\n";
	         expectedOutput += "Pat is getting out of the penalty box\n";
	         expectedOutput += "Pat's new location is 5\n";
	         expectedOutput += "The category is Science\n";
	         expectedOutput += "Science Question 2\n";
	         expectedOutput += "Question was incorrectly answered\n";
	         expectedOutput += "Pat was sent to the penalty box\n";
	         expectedOutput += "Sue is the current player\n";
	         expectedOutput += "They have rolled a 3\n";
	         expectedOutput += "Sue's new location is 6\n";
	         expectedOutput += "The category is Sports\n";
	         expectedOutput += "Sports Question 1\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Sue now has 4 Gold Coins.\n";
	         expectedOutput += "Chet is the current player\n";
	         expectedOutput += "They have rolled a 4\n";
	         expectedOutput += "Chet's new location is 7\n";
	         expectedOutput += "The category is Rock\n";
	         expectedOutput += "Rock Question 3\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Chet now has 5 Gold Coins.\n";
	         expectedOutput += "Pat is the current player\n";
	         expectedOutput += "They have rolled a 3\n";
	         expectedOutput += "Pat is getting out of the penalty box\n";
	         expectedOutput += "Pat's new location is 8\n";
	         expectedOutput += "The category is Pop\n";
	         expectedOutput += "Pop Question 4\n";
	         expectedOutput += "Answer was correct!!!!\n";
	         expectedOutput += "Pat now has 3 Gold Coins.\n";
	         expectedOutput += "Sue is the current player\n";
	         expectedOutput += "They have rolled a 5\n";
	         expectedOutput += "Sue's new location is 11\n";
	         expectedOutput += "The category is Rock\n";
	         expectedOutput += "Rock Question 4\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Sue now has 5 Gold Coins.\n";
	         expectedOutput += "Chet is the current player\n";
	         expectedOutput += "They have rolled a 4\n";
	         expectedOutput += "Chet's new location is 11\n";
	         expectedOutput += "The category is Rock\n";
	         expectedOutput += "Rock Question 5\n";
	         expectedOutput += "Answer was corrent!!!!\n";
	         expectedOutput += "Chet now has 6 Gold Coins.\n";
	         return expectedOutput;
	     }
}
