package blackjack;
import java.util.Random;

import cards.*;

public class deck{
	private card[] deck;
	public int deckpointer;
	public deck(){
		deck = card.constructDeck();
		deckpointer = 0;
	}
	
	public void shuffle() {
		card[] shuffled = new card[52];
		Random rand = new Random();
		for(int i = 0; i < 52; ++i) {
			int index = rand.nextInt(52);
			while(shuffled[index]!=null) {
				index++;
				index = index%52;
			}
			shuffled[index] = deck[i];
		}
		deck = shuffled;
		deckpointer = 0;
	}
	
	public void printDeck() {
		for(int i = 0; i < 52; ++i) {
			deck[i].printCard();
		}
		
	}
	
	public card draw(){
		if(deckpointer == 52) {
			System.out.println("The deck is empty! Automatically shuffling....");
			shuffle();
			return deck[deckpointer];
		}
		else {
			card draw = deck[deckpointer];
			deckpointer++;
			return draw;
		}
	}
}
