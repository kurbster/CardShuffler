package objects;

import java.util.ArrayList;
import java.util.List;

//The deck object is the object that represents the deck we shuffle with
//Which just a list of cards when you initialize the deck you initialize
//A list of 52 empty cards then based on which starting method you want
//You call the specific method
public class Deck {
	private List<Card> deck;
	private int sizeList;
	public Deck(int size){
		deck = new ArrayList<Card>(size);
		sizeList = size;
	}
	
	public int getSize(){
		return sizeList;
	}
	public List<Card> getCurrentDeck(){
		return deck;
	}
	
	public Card getCard(int index){
		return deck.get(index);
	}
	
	public void setCard(Card newCard, int index){
		deck.set(index, newCard);
	}
	
	public void getNumberDeck(){
		String value, suit = "";
		for(int i = 1; i <= 10; i++){
			value = Integer.toString(i);
			Card c = new Card(value, suit);
			deck.add(c);
		}
	}
	public void getStandardDeck(){
		//Checking that the deck is empty
		if(!deck.isEmpty())
			deck.clear();
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
				deck.add(c);
			}
		}
	}
}
