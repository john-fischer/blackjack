package cards;

public class card {


	private String type; // ace, 3, king, jack, etc.
	private String suite;
	private int id; // the numeral associated with each type
	private static String[] cardTypes = new String[] {
			"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine","ten", "jack", "queen","king"
	};
	private static String[] suiteTypes = new String[] {
			"clubs", "spades", "diamonds", "hearts"
	};
	
	public card(String type, String suite) {
		int a = 0;
		int b = 0;
		boolean valid_type = false;
		boolean valid_suite = false;
		String checkType = type.toLowerCase().trim();
		String checkSuite = suite.toLowerCase().trim();
		for(int i = 0; i < 13; ++i) {
			if(checkType.equals(cardTypes[i])) {
				valid_type = true;
				a = i+1;
				break;
			}
		}
		
		for(int i = 0; i < 4; ++i) {
			if(checkSuite.equals(suiteTypes[i])) {
				valid_suite = true;
				b = i *100;
				break;
			}
		}
		if(valid_type && valid_suite) {
			this.id = a+b;
			this.suite = checkSuite;
			this.type = checkType;
			
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String displayCard() {
		String returnString = getType() +  " of " + getSuite();
		return returnString;
		
	}
	
	public void printCard() {
		String returnString = getType() +  " of " + getSuite();
		System.out.println(returnString);
	}
	
	public static card[] constructDeck(){
		card[] deck = new card[52];
		for(int i =0; i < 4; ++i) {
			for(int j =0; j < 13; ++j) {
				deck[i*13+j] = new card(cardTypes[j], suiteTypes[i]);
			}
		}
		return deck;
		
	}
	
	
}
