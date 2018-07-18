package player;
import java.util.ArrayList;

import blackjack.*;
import cards.*;

public class player {
	
	ArrayList<card> hand;
	private String name;
	
	public player(String name) {
		hand = new ArrayList<card>(2);
		this.name = name;
	}
	
	public void drawHand(deck d) {
		for(int i = 0; i < 2; i++) {
			hand.add(d.draw());
		}
	}
	
	public String showHand() {
		String h = "";
		for(int i = 0 ; i < hand.size(); ++i) {
			if(i == hand.size()-1) {
				h += hand.get(i).displayCard();
			}
			else {
			h += hand.get(i).displayCard() + ", ";
			}
		}
		return h;
	}
	
	public void printHand() {
		String h = showHand();
		System.out.println(h);
	}
	
	public int scoreHand() {
		int total = 0;
		for(card c : hand)
		{
			int value =c.getId()%100;
			if(value > 10) {
				value = 10;
			}
			total += value;
		}
		return total;
	}
	
	public void drawCard(deck d) {
		hand.add(d.draw());
		
	}
	
	public void clearhand() {
		hand.removeAll(hand);
	}

	
}
