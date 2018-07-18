package testing;
import cards.*;
import player.*;
import blackjack.*;


public class mainclass {

	public static void main(String[] args) {
		
		
	
		player me = new player("Jack");
		game game = new game();
		game.play(me);
		
	}

}
