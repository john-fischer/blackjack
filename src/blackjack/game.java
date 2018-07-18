package blackjack;

import player.*;
import java.util.Scanner;

public class game {

	public game() {

	}

	public void play(player p) {
		deck deck = new deck();
		Scanner sc = new Scanner(System.in);
		dealer dealer = new dealer();
		boolean running = true;
		mainloop: while (running) {
			deck.shuffle();
			deck.shuffle();
			deck.shuffle();
			p.clearhand();
			dealer.clearhand();
			p.drawHand(deck);
			dealer.drawHand(deck);
			dealer.printHand();
			p.printHand();
			playerloop: while (true) {
				System.out.println("Do you want to hit or stand?");
				String choice = sc.nextLine();
				if (choice.toLowerCase().equals("hit") || choice.toLowerCase().equals("stand")) {
					if (choice.toLowerCase().equals("hit")) {
						p.drawCard(deck);
						p.printHand();
						if (p.scoreHand() > 21) {
							System.out.println("BUST - you lose!");
							System.out.println("Continue?");
							choice = sc.nextLine();
							if (choice.toLowerCase().equals("yes")) {
								continue mainloop;
							} else {
								break mainloop;
							}
						}
					} else {
						break playerloop;
					}

				} else {
					System.out.println("Please choose a valid command");
					continue playerloop;
				}
			}
			dealerloop: while (true) {
				if (dealer.scoreHand() < 17) {
					dealer.drawCard(deck);
					dealer.printHand();
				} else {
					break dealerloop;
				}
			}
			dealer.printFinalHand();
			p.printHand();
			if (dealer.scoreHand() > 21) {
				System.out.println("Dealer Busts, you win!");
				System.out.println("Continue?");
				String choice = sc.nextLine();
				if (choice.toLowerCase().equals("yes")) {
					continue mainloop;
				} else {
					break mainloop;
				}
			}
			if (p.scoreHand() > dealer.scoreHand()) {
				System.out.println("You win!");
				System.out.println("Dealer Scored: " + dealer.scoreHand());
				System.out.println("You Scored: " + p.scoreHand());
				System.out.println("Continue?");
				String choice = sc.nextLine();
				if (choice.toLowerCase().equals("yes")) {
					continue mainloop;
				} else {
					break mainloop;
				}
			} else {
				System.out.println("You Lose!");
				System.out.println("Dealer Scored: " + dealer.scoreHand());
				System.out.println("You Scored: " + p.scoreHand());

				System.out.println("Continue?");
				String choice = sc.nextLine();
				if (choice.toLowerCase().equals("yes")) {
					continue mainloop;
				} else {
					break mainloop;
				}
			}
		}
		sc.close();
	}

}
