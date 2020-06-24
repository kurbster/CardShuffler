import java.util.ArrayList;
import java.util.List;

import objects.Card;
import objects.PerfectShuffle;
import input_output.OutputManager;

//Created by Kirby Kuznia on 1/14/19
//This program will see which shuffling styles would shuffle the 
//Deck in the least possible terms, we measure this by the standard
//I call well-mixed where no 2 cards that started next to each other
//Are next to each other, I define poker well-mixed as if the deck were
//Played out in a poker hand with 4 people then there would be no melds
//Only high card hands that round, with the flop, turn and river
public class main {
	private static List<Card> cards = new ArrayList<Card>(52);
	private static List<Card> unshuffledDeck = new ArrayList<Card>(52);
	
	//This method creates a card object for every card in the deck giving
	//Us our starting deck
	private static void initCards(){
		String suit, value;
		//For each of the 4 suits
		for(int i = 1; i <= 4; i++){
			//For each of the 13 cards in each suit
			for(int j = 1; j <= 13; j++){
				//Add it to our array
				switch (i) {
				case 1:
					suit = "H";
					break;
				case 2:
					suit = "C";
					break;
				case 3:
					suit = "D";
					break;
				case 4:
					suit = "S";
					break;
				default:
						suit = "";
				}
				switch (j) {
				case 1:
					value = "A";
					break;
				case 2:case 3:case 4:case 5:
				case 6:case 7:case 8:case 9:case 10: 
					value = Integer.toString(j);
					break;
				case 11:
					value = "J";
					break;
				case 12:
					value = "Q";
					break;
				case 13:
					value = "K";
					break;
				default:
					value = "";
				}
				Card c = new Card(value, suit);
				cards.add(c);
			}
		}
	}
	
	private static void printDeck(List<Card> deck){
		deck.forEach((n) -> System.out.println(n.getValue() + n.getSuit()));
	}
	
	public static void main(String[] args) {
		initCards();	//Init the deck
		unshuffledDeck = cards;		//Save the unshuffled deck for comparison
		PerfectShuffle shuf = new PerfectShuffle(cards);	//Create a new shuffling object
		List<Card> deck = shuf.fullyShuffle();		//Call the shuffling mehtod
		OutputManager output = new OutputManager();
		output.writeFile(unshuffledDeck, deck, "Random");
		printDeck(deck);
	}

}
