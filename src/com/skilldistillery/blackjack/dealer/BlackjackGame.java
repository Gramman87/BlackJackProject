package com.skilldistillery.blackjack.dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.game.BlackjackDealer;

public class BlackjackGame {
	Scanner sc = new Scanner(System.in);
	private List<Player> players;

	BlackjackDealer dealer = new BlackjackDealer("Dealer");

	public BlackjackGame() {
	}

	public void launch() {

		System.out.println("Welcome to Blackjack!");
		System.out.println();
		System.out.println("How many players (1-4): ");
		addPlayer(sc.nextInt());
		sc.nextLine();
		players.add(dealer);

		System.out.println("Lets play some Blackjack!");

		startGame(players);
		

	}

	private void showHand() {
		for (Player player : players) {
			if(player instanceof BlackjackDealer) {
				player.showDealerHand();
			} else {
				player.showHand();
			}
		}
		
	}
	
	private void getHandValue() {
		for (Player player : players) {
			player.getHandValue();
		}
	}

	private void addPlayer(int numPlayers) {
		players = new ArrayList<>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player("Player " + (i + 1)));
		}

	}

	public void startGame(List<Player> players) {

		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.buildHand(dealer.dealCard());
			}
		}

		showHand();
	}

	public void playGame() {

	}
}
