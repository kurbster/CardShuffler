import java.util.ArrayList;
import java.util.List;

import objects.Card;
import objects.Deck;
import objects.Shuffler;
import input_output.OutputManager;

//Created by Kirby Kuznia on 1/14/19
//This program will see which shuffling styles would shuffle the 
//Deck in the least possible terms, we measure this by the standard
//I call well-mixed where no 2 cards that started next to each other
//Are next to each other, I define poker well-mixed as if the deck were
//Played out in a poker hand with 4 people then there would be no melds
//Only high card hands that round, with the flop, turn and river
public class main {
				
	private static void printDeck(List<Card> deck){
		deck.forEach((n) -> System.out.println(n.getCard()));
	}
	
	public static void main(String[] args) {
		//TODO Different args would call different shuffling mehtods
		Deck myDeck = new Deck(10);	//This creates a blank deck
		myDeck.getNumberDeck();	//This shuffles the deck
		Shuffler shuf = new Shuffler(myDeck);	//Create a new shuffling object
		shuf.randomShuffle();		//Call the shuffling mehtod
		OutputManager output = new OutputManager();
//		output.writeFile(unshuffledDeck, deck, "Random");
//		printDeck(deck);
	}

}
