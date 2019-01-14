import java.util.ArrayList;

//Created by Kirby Kuznia on 1/14/19
//This program will see which shuffling styles would shuffle the 
//Deck in the least possible terms, we measure this by the standard
//I call well-mixed where there are no pairs and no same suited cards
//Next to each other, I define poker well-mixed as if the deck were
//Played out in a poker hand with 4 people then there would be no melds
//Only high card hands that round, with the flop, turn and river
public class main {
	private static ArrayList<Card> cards = new ArrayList<Card>();
	
	//This method
	private static void initCards(){
		String suit, value;
		//For each of the 4 suits
		for(int i = 1; i <= 4; i++){
			//For each of the 13 cards in each suit
			for(int j = 1; j <= 13; j++){
				//Add it to our array
				switch (i) {
				case 1:
					suit = "Hearts";
					break;
				case 2:
					suit = "Clubs";
					break;
				case 3:
					suit = "Diamonds";
					break;
				case 4:
					suit = "Spades";
					break;
				default:
						suit = "";
				}
				switch (j) {
				case 1:
					value = "Ace";
					break;
				case 2:case 3:case 4:case 5:
				case 6:case 7:case 8:case 9:case 10: 
					value = Integer.toString(j);
					break;
				case 11:
					value = "Jack";
					break;
				case 12:
					value = "Queen";
					break;
				case 13:
					value = "King";
					break;
				default:
					value = "";
				}
				Card c = new Card(value, suit);
				cards.add(c);
			}
		}
	}
	
	private static void printCards(){
		cards.forEach( (n) -> System.out.println(n.getValue() + " of " + n.getSuit()));
	}
	
	public static void main(String[] args) {
		initCards();
		printCards();
	}

}
