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
		System.out.println("How many players (1-8): ");
		addPlayer(sc.nextInt());
		sc.nextLine();
		players.add(dealer);

		System.out.println("Lets play some Blackjack!");

		startGame(players);

	}

	private void showHand() {
		for (Player player : players) {
			if (player instanceof BlackjackDealer) {
				player.showDealerHand();
			} else {
				player.showHand();
			}
		}

	}

	private void addPlayer(int numPlayers) {
		players = new ArrayList<>();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player("Player " + (i + 1)));
		}

	}

	public void startGame(List<Player> players) {
		dealer.newDeck();
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.buildHand(dealer.dealCard());
			}
		}

		for (Player player : players) {
			if (player.handValue() == 21) {
				if (player instanceof BlackjackDealer) {
					System.out.println("Better luck next time!");
				}
				player.showHand();
				System.out.println("BLACKJACK!!!");

				anotherGame();
			}
		}

		showHand();
		System.out.println("=======================================");
		System.out.println();
		playGame();
	}

	public void nextGame(List<Player> players) {
		System.out.println("=======================================");

		dealer.newDeck();

		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.buildHand(dealer.dealCard());
			}
		}

		for (Player player : players) {
			if (player.handValue() == 21) {
				if (player instanceof BlackjackDealer) {
					System.out.println("Better luck next time!");
				}
				player.showHand();
				System.out.println("BLACKJACK!!!");

				anotherGame();
			}
		}

		showHand();
		System.out.println("=======================================");
		System.out.println();
		playGame();
	}

	public void playGame() {
		for (Player player : players) {
			boolean playerUp = true;
			String userInput = "";
			while (playerUp) {
				if (player instanceof BlackjackDealer) {
					System.out.println();
					player.showHand();
					if (player.playerHand.getHandValue() >= 17 && player.playerHand.getHandValue() <= 21) {
						player.showHand();
						playerUp = false;
						break;
					}
					if (player.playerHand.getHandValue() > 21) {
						System.out.println("Dealer BUST!");
						playerUp = false;
						break;

					} else if (player.playerHand.getHandValue() < 17) {
						player.buildHand(dealer.dealCard());
						player.showHand();
					}
				} else {
					System.out.println();
					player.showHand();
					System.out.println(player.getName() + " would you like to Hit or Stay?");
					System.out.print("Please press \"H\" for Hit and \"S\" for Stay: \t");
					userInput = sc.nextLine();
					if (userInput.equalsIgnoreCase("H")) {
						player.buildHand(dealer.dealCard());
						if (player.playerHand.getHandValue() > 21) {
							System.err.println("Player BUST!");
							player.showHand();
							System.out.println("=======================================");
							playerUp = false;
							break;
						}
					} else if (userInput.equalsIgnoreCase("S")) {
						player.showHand();
						System.out.println("=======================================");
						playerUp = false;
						break;
					} else {
						System.err.println("Please make a valid selection.");
					}
				}
			}
		}

		decideGame();
	}

	private void decideGame() {
		int dealerHand = players.get(players.size() - 1).handValue();
		for (int i = 0; i < players.size() - 1; i++) {
			if (players.get(i).handValue() > dealerHand && players.get(i).handValue() < 22 || dealerHand > 21 && players.get(i).handValue() < 22) {
				System.out.println(players.get(i).getName());
				System.out.println("Congrats... You BEAT the House!");
			} else if (players.get(i).handValue() == dealerHand) {
				System.out.println(players.get(i).getName());
				System.out.println("PUSH...");
			} else if (players.get(i).handValue() < dealerHand && players.get(i).handValue() < 22) {
				System.out.println(players.get(i).getName());
				System.out.println("Better luck next time...");
			}

		}

		anotherGame();
	}

	private void anotherGame() {
		System.out.print("Another hand? ");
		String userInput = sc.nextLine();

		if (userInput.equalsIgnoreCase("Y")) {
			for (Player player : players) {
				player.fold();
			}
			nextGame(players);
		} else if (userInput.equalsIgnoreCase("N")) {
			System.out.println("Thanks for playning! Goodbye.");
		}

		System.out.println();
	}

}
