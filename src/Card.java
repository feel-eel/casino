public class Card {


	private String suit;
	private int pointValue;
	private String rank;
	
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		//initializes a new Card with the given rank, suit, and point value
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}

	public String suit() {
		return suit;
	}

	
	public String rank() {
		return rank;
	}
	
	

	public int pointValue() {
		return pointValue;
	}
	
	@Override
	public String toString() {
		return "THE " + rank.toUpperCase() + " OF " + suit.toUpperCase() + ".";
	}
	
}