package com.skilldistillery.blackjack.dealer;

public class Player {
	private String name;
	protected BlackjackHand playerHand;

	public Player(String name) {
		this.name = name;
		playerHand = new BlackjackHand();
	}
	
	public void buildHand(Card card) {
		playerHand.buildHand(card);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player name: " + name;
	}

}
