package com.adaptionsoft.games.uglytrivia;

public class Player {
	int place;
	String name;
	
	public Player(String name) {
		super();
		this.name = name;
		this.place = 0;
	}
	
	public void moveTo(int newPlace) {
		this.place = newPlace;
	}
	
	public int place() { return this.place; }
}
