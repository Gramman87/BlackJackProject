package com.skilldistillery.blackjack.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
	Scanner sc = new Scanner(System.in);
	private List<Player> players;
	private boolean userGame = true;
	private int userInput;

	public BlackjackGame() {

	}

	public void launch() {

		System.out.println("Welcome to the Casino!");
		
		while (userGame) {
			printMenu();
			System.out.print("Please choose from the menu below: ");
			userInput = sc.nextInt();
			sc.nextLine();
			
			switch (userInput) {
			case 1:
				System.out.print("How many will be playing (1-4): ");
				addPlayer(sc.nextInt());
				break;
			case 2:
				System.out.println("Lets play some Blackjack!");
				BlackjackDealer gameDealer = new BlackjackDealer();
				gameDealer.dealGame();
			default:
				break;
			}
		}

	}

	public void printMenu() {

		System.out.println();
		System.out.println("======= MAIN MENU =======");
		System.out.println("|                       |");
		System.out.println("|    1. Add Player      |");
		System.out.println("|                       |");
		System.out.println("|    2. Begin Game      |");
		System.out.println("|                       |");
		System.out.println("|    0. Exit            |");
		System.out.println("|                       |");
		System.out.println("=========================");
		System.out.println();

	}
	
	public void addPlayer(int numPlayers) {
		players = new ArrayList<>();
		for(int i = 0; i < numPlayers; i++) {
			players.add(new Player("Player " + (i + 1)));
			
		}
		
	}

}
