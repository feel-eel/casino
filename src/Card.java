import java.util.ArrayList;

public class Card implements Comparable<Card>{


	private String suit;
	private int pointValue;
	private String rank;
	private ArrayList<Card> cards;
	
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
	
	public int sumHand() {
		int sum = 0;
		for(int i = 0; i < cards.size(); i++) {
			sum += cardAt(i).pointValue();
		}
		return sum;
	}
	public Card cardAt(int k) {
		return cards.get(k);
	}
	
	
	@Override
	public String toString() {
		return "THE " + rank.toUpperCase() + " OF " + suit.toUpperCase() + ".";
	}
	
	@Override
	   public int compareTo(Card card) {
	        if (this.sumHand() > card.sumHand()) {
	            return 1;
	        } else if (this.sumHand() < card.sumHand()) {
	            return -1;
	        } else {
	            return 0;
	        }
	    }
	
}