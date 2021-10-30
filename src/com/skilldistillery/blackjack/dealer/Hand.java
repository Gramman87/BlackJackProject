package com.skilldistillery.blackjack.dealer;

import java.util.List;

public abstract class Hand {
	protected List<Card> playerHand;

	public abstract void buildHand(Card card);

	public abstract void fold();

	public abstract int getHandValue();

}
