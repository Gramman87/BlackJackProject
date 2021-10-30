package com.skilldistillery.blackjack.dealer;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		playerHand = new ArrayList<>();
	}

	@Override
	public void buildHand(Card newCard) {
		playerHand.add(newCard);
	}

	@Override
	public void fold() {
		for (Card card : playerHand) {
			playerHand.remove(card);
		}

	}

	@Override
	public int getHandValue() {
		int handValue = 0;

		for (Card card : playerHand) {
			handValue += card.getValue();
		}

		return handValue;
	}

}
