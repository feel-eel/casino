import java.util.Scanner;

public class Game {

	private Deck deck;
	private Player player;
	
	
	//private void dealMyCards() {
	//	for (int k = 0; k < cards.length; k++) {
	//		cards[k] = deck.deal();
	//	}
	//}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player newPlayer) {
		player = newPlayer;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void setDeck(Deck newDeck) {
		deck = newDeck;
	}
	
	public static void main(String[] args) { 
		Game g = new Game();
		System.out.println("Hello welcome to blackjack! You are starting with 25 chips, each chip is worth a dollar.");
		System.out.println("You must bet at least one chip per dollar.");
		System.out.println("You will be dealt two cards at the start of the round. The dealer will also be dealt two but one will be face down.");
		System.out.println("You can HIT to get a new card or STAND to stop. The dealer must hit until the card values are worth 17.");
		System.out.println("Closest to 21 wins. \n");
		
		int chips = 25;
		boolean quit = false;
		while (!quit) {
			Hand hand = new Hand();
			Hand dealerHand = new Hand();
			Player player = new Player(chips, hand);
			
			Scanner in = new Scanner(System.in);
			
			String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
			String[] suits = {"hearts", "clubs", "spades", "diamonds"};
			int[] pointValues = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
			Deck deck = new Deck(ranks, suits, pointValues);
			
			
				System.out.println("\nWould you like to play? Type QUIT to stop, press any key to begin");
				String playing = in.nextLine();
				
				if (playing.equals("QUIT") || playing.equals("quit")) {
					quit = true;
					break;
				}
				int betChips = 15;
				boolean betValid = false;
				while (!betValid) {
					System.out.println("How much would you like to bet?");
					betChips = in.nextInt();
					if (betChips <= chips) {
						betValid = true;
					} else {
						System.out.println("You cannot bet more than you have.");
					}
				}
				
				
				
				Card p1 = deck.deal();
				Card p2 = deck.deal();
				
				hand.newCard(p1);
				hand.newCard(p2);
				
				System.out.println("Your first card is " + p1.toString() + " Your second is " + p2.toString() + " Your score is " + hand.sumHand());
				
				Card d1 = deck.deal();
				Card d2 = deck.deal();
				
				dealerHand.newCard(d1);
				
				
				System.out.println("The dealer's first card is " + d1.toString() + " The dealer's score is " + dealerHand.sumHand());
				
				boolean standP = false;
				boolean overP = false;
				boolean standD = false;
				boolean overD = false;
				
				if (hand.containsBlackJack()) {
					overP = true;
					System.out.println("You win! You now have " + (chips + betChips) + " chips.");
					player.setChip(chips+ betChips);
					chips += betChips;
				}
				
				String extra = in.nextLine();
				
				
				while (!standP && !overP && !standD && !overD) {
					System.out.println("Are you going to HIT or STAND?");
			
					String reply = in.nextLine();
					
					if (reply.equals("HIT") || reply.equals("hit")) {
						Card pNew= deck.deal();
						if (hand.sumHand() > 10 && pNew.rank() == "ace") {
							pNew = new Card("ace", pNew.suit(), 1);
						}
						hand.newCard(pNew);
						System.out.println("Your new card is " + pNew.toString() + " Your score is " + hand.sumHand());
						
//						if (dealerHand.sumHand() < 17) {
//							Card dNew = deck.deal();
//							if (dealerHand.sumHand() > 10 && dNew.rank() == "ace") {
//								dNew = new Card("ace", dNew.suit(), 1);
//							}
//							dealerHand.newCard(dNew);
//							System.out.println("\nThe Dealer's new card is " + dNew.toString() + " The dealer's new score is " + dealerHand.sumHand());
//						}
						
					} else if (reply.equals("STAND") || reply.equals("stand")) {
						standP = true;
						dealerHand.newCard(d2);
						if (dealerHand.sumHand() > 10 && d2.rank() == "ace") {
							d2 = new Card("ace", d2.suit(), 1);
						}
						System.out.println("The Dealer's hidden card is " + d2.toString() +  " The dealer's score is " + dealerHand.sumHand());
					} else {
						System.out.println("Please enter a valid reply");
					}
					
					
					if(hand.sumHand() > 21) {
						overP = true;
						System.out.println("You lose! You now have " + (chips- betChips) + " chips.");
						player.setChip(chips- betChips);
						chips -= betChips;
						break;
					} else if (hand.sumHand() == 21) {
						overP = true;
						System.out.println("You win! You now have " + (chips + betChips) + " chips.");
						player.setChip(chips+ betChips);
						chips += betChips;
						break;
					}
					
					
				}
				
				while (dealerHand.sumHand() < 17 && !overP) {
					Card dNew = deck.deal();
					if (dealerHand.sumHand() > 10 && dNew.rank() == "ace") {
						dNew = new Card("ace", dNew.suit(), 1);
					}
					dealerHand.newCard(dNew);
					System.out.println("The Dealer's new card is " + dNew.toString() + " The dealer's new score is " + dealerHand.sumHand());
				}					
				if (21 - dealerHand.sumHand() < 0 && !overP) {
					System.out.println("You win! You now have " + (chips + betChips) + " chips.");
					player.setChip(chips+ betChips);
					chips += betChips;
				} else if (21 - dealerHand.sumHand() < 21 - hand.sumHand() && !overP) {		
					System.out.println("You lose! You now have " + (chips - betChips) + " chips.");
					player.setChip(chips- betChips);
					chips -= betChips;
				} else if (!overP){
					System.out.println("You win! You now have " + (chips + betChips) + " chips.");
					player.setChip(chips+ betChips);
					chips += betChips;
				}
				
				if (chips == 0) {
					quit = true;
					System.out.println("You are out of chips! Goodbye");
				}
				
				}
				
				
			}
			
		}
		
		
