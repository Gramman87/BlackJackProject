package com.skilldistillery.blackjack;


public enum Suit {
	HEART ("Heart"), SPADE ("Spade"), CLUB ("Club"), DIAMOND ("Diamond");
	
	private final String name;
	
	Suit(String suit) {
		name = suit;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
