package com.skilldistillery.blackjack.dealer;

public enum Suit {
	HEART("\u2665\uFE0F"), SPADE("\u2660\uFE0F"), CLUB("\u2663\uFE0F"), DIAMOND("\u2666\uFE0F");

	private final String name;

	Suit(String suit) {
		name = suit;
	}

	@Override
	public String toString() {
		return name;
	}

}
