package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.dealer.Card;
import com.skilldistillery.blackjack.dealer.Deck;
import com.skilldistillery.blackjack.dealer.Player;

public class BlackjackDealer extends Player {
	private Deck gameDeck;

	public BlackjackDealer(String name) {
		super(name);
	}

	public Card dealCard() {
		return gameDeck.getCard();
	}
	
	public void newDeck() {
		gameDeck = new Deck();
	}
	
	public void shuffleDeck() {
		gameDeck.shuffleDeck();
	}
	
}
