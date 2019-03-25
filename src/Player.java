public class Player {


	private int chips;
	private Hand hand;
	
	public Player(int chipValue, Hand newHand) {
		chips = chipValue;
		hand = newHand;
	}

	public int getChip() {
		return chips;
	}
	
	public void setChip(int chipValue) {
		chips = chipValue;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand hands) {
		hand = hands;
	}

}