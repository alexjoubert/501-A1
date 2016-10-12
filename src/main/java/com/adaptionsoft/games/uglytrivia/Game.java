package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

public class Game {
    ArrayList players = new ArrayList();
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayer = 0;
    List<Player> playersList;
    boolean isGettingOutOfPenaltyBox;
    
    private Random rand;
    
    public  Game(Random rand){
    	playersList = new ArrayList<Player>();
    	this.rand = rand;
    	
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast("Rock Question " + i);
    	}
    }
    
    public void run() {
    	boolean notAWinner = true;
    	
    	do {
    		this.roll(rand.nextInt(5) + 1);
    		
    		if (rand.nextInt(9) == 7) {
    			notAWinner = this.wrongAnswer();
    		}  else {
    			notAWinner = this.wasCorrectlyAnswered();
    		}
    	} while (notAWinner);
    }
    
	public boolean add(String playerName) {
	    playersList.add(new Player(playerName));
	    players.add(playerName);
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	private int howManyPlayers() {
		return players.size();
	}

	private void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				setCurrentPlayerPlace(getCurrentPlayerPlace() + roll);
				if (getCurrentPlayerPlace() > 11) setCurrentPlayerPlace(getCurrentPlayerPlace() - 12);
				
				System.out.println(players.get(currentPlayer) 
						+ "'s new location is " 
						+ getCurrentPlayerPlace());
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			setCurrentPlayerPlace(getCurrentPlayerPlace() + roll);
			if (getCurrentPlayerPlace() > 11) setCurrentPlayerPlace(getCurrentPlayerPlace() - 12);
			
			System.out.println(players.get(currentPlayer) 
					+ "'s new location is " 
					+ getCurrentPlayerPlace());
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (getCurrentPlayerPlace() == 0) return "Pop";
		if (getCurrentPlayerPlace() == 4) return "Pop";
		if (getCurrentPlayerPlace() == 8) return "Pop";
		if (getCurrentPlayerPlace() == 1) return "Science";
		if (getCurrentPlayerPlace() == 5) return "Science";
		if (getCurrentPlayerPlace() == 9) return "Science";
		if (getCurrentPlayerPlace() == 2) return "Sports";
		if (getCurrentPlayerPlace() == 6) return "Sports";
		if (getCurrentPlayerPlace() == 10) return "Sports";
		return "Rock";
	}

	private boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer) 
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	private boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
	
	private Player currentPlayer() {
		return playersList.get(currentPlayer);
	}
	
	private int getCurrentPlayerPlace() {
		return currentPlayer().place();
	}
	
	private void setCurrentPlayerPlace(int newPlace) {
		currentPlayer().moveTo(newPlace);
	}
	
}
