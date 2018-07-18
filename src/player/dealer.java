package player;

public class dealer extends player{
	int hand_total;
	
	public dealer(){
		super("dealer");
	}
	
	public String showHand() {
		String h = "**HIDDEN** ";
		for(int i = 1 ; i < hand.size(); ++i) {
			if(i == hand.size()-1) {
				h += hand.get(i).displayCard();
			}
			else {
			h += hand.get(i).displayCard() + ", ";
			}
		}
		return h;
	}
	public void printFinalHand() {
		String h = "";
		for(int i = 0 ; i < hand.size(); ++i) {
			if(i == hand.size()-1) {
				h += hand.get(i).displayCard();
			}
			else {
			h += hand.get(i).displayCard() + ", ";
			}
		}
		System.out.println(h);
	}
	
	
	
	

}
