package com.skilldistillery.blackjack.dealer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();

	public Deck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		shuffleDeck();
	}

	public int cardsRemaining() {
		return deck.size();
	}

	public Card getCard() {
		return deck.remove(0);
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

}
