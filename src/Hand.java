import java.util.ArrayList;
import java.util.List;

//holds the cards and knows what the card value is

public class Hand {

	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	private static final int[] POINT_VALUES =
		{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	// make arraylist
	private ArrayList<Card> cards;
//	private Game game;
//	private Deck deck;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	
	public int cardSum(List<Integer> selectedCards) {
		int sum = 0;
		for(int i = 0; i < selectedCards.size(); i++) {
			sum += cardAt(i).pointValue();
		}
		return sum;
	}
	
	
	
	public int sumHand() {
		int sum = 0;
		for(int i = 0; i < cards.size(); i++) {
			sum += cardAt(i).pointValue();
		}
		return sum;
	}
	//public void deal(int k) {
	//	cards.set(k, deck.deal());
	//}

	public Card cardAt(int k) {
		return cards.get(k);
	}
	
	public void newCard(Card cardNew) {
		cards.add(cardNew);
	}
	
	public boolean containsBlackJack() {
		boolean j = false;
		boolean k = false;
		boolean q = false;
		boolean a = false;
		boolean ten = false;
		
		for (int index = 0; index < cards.size(); index++) {
			if (cardAt(index).rank() == "Jack" || cardAt(index).rank() == "jack") {
				j = true;
			} else if (cardAt(index).rank() == "Queen" || cardAt(index).rank() == "queen") {
				q = true;
			} else if (cardAt(index).rank() == "King" || cardAt(index).rank() == "king") {
				k = true;
			} else if ((cardAt(index).rank() == "Ace" || cardAt(index).rank() == "ace")) {
				a = true;
			} else if ((cardAt(index).rank() == "10")) {
				ten = true;
			}
		}
		if ((j && a) || (a && q) || (a && k) || (a && ten)) {
			return true;
		}
		return false;
	}
	

	
}
	