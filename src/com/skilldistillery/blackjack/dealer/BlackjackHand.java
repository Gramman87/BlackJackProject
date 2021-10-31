package com.skilldistillery.blackjack.dealer;

import java.util.ArrayList;

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

	public void showHand() {
		for (Card card : playerHand) {
			System.out.print(card.toString());
		}
		System.out.println();
	}

	public void showDealerHand() {
		for(int i = 1; i < playerHand.size(); i++) {
			System.out.print(playerHand.get(i));
		}
		System.out.println();
	}

}
