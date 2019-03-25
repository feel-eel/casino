import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<Card> {
		
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	
	private static final int[] POINT_VALUES =
		{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	
	private Hand hand;
	
	public void shuffle() {
		for (int k = this.size() - 1; k > 0; k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = this.get(k);
			this.set(k, this.get(randPos));
			this.set(randPos, temp);
		}
	}
	
	public Deck(String[] ranks, String[] suits, int[] values) {
		super();
		
		for (int j = 0; j < ranks.length; j++) {
			for (String suitString : suits) {
				this.add(new Card(ranks[j], suitString, values[j]));
			}
		}
		shuffle();
	}
	
	public Card deal() {
		if (isEmpty()) {
			return null;
		}
		
		return this.remove(this.size() - 1);
	}
	
//	public Card aceValue(Card ace) {
//		
//		if (hand.sumHand() > 10 && card.rank() == "ace") {
//			return new Card("ace", "hearts", 1);
//		} else {
//			return ace;
//		}
//	}
	
	@Override
	public String toString() {
		return "The " + RANKS + "of " + SUITS;
	}

}

// make an array list for cards for cards w rank
// find out card rank
// player class w instance variable chips
// 




