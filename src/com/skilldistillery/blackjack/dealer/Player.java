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
	
	public void getHandValue() {
		playerHand.getHandValue();
	}
	
	public int handValue() {
		return playerHand.getHandValue();
	}
	
	public void showHand() {
		System.out.println(getName());
		playerHand.showHand();
		System.out.println("\t" + playerHand.getHandValue());
		System.out.println();
	}
	
	public void showDealerHand() {
		System.out.println(getName());
		playerHand.showDealerHand();
		System.out.println("\t" + playerHand.showDealerHandValue());
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

	public void fold() {
		playerHand.fold();
	}


}
