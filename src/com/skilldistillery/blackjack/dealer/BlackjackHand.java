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
		playerHand.removeAll(playerHand);
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
	}

	public int showDealerHandValue() {
		int dealerShowValue = 0;
		for (int i = 1; i < playerHand.size(); i++) {
			dealerShowValue += playerHand.get(i).getValue();
		}

		return dealerShowValue;
	}

	public void showDealerHand() {
		for (int i = 1; i < playerHand.size(); i++) {
			System.out.print(playerHand.get(i));
		}
	}

}
