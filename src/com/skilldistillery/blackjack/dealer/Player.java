package com.skilldistillery.blackjack.dealer;

import java.util.List;

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
	
	public void getHandValue() {
		System.out.println(playerHand.getHandValue());
	}
	
	public void showHand() {
		System.out.println(getName());
		playerHand.showHand();
	}
	
	public void showDealerHand() {
		System.out.println(getName());
		playerHand.showDealerHand();
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
