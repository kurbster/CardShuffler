package objects;
import java.util.*;

public class Shuffler {
	private static final int RAND_BOUND = 4;
	private Random generator = new Random();
	//I make this static so there is only one instance therefore
	//The deck remains intact in between shuffle once methods
	private static Deck ourDeck;
	
	public Shuffler(Deck inputDeck){
		ourDeck = inputDeck;
	}
	
	//This method will call the shuffleOnce method however many times is needed
	public Deck randomShuffle(){
		shuffleOnceRandom();
		shuffleOnceRandom();
		return ourDeck;
	}
	private static void printDeck(Deck myDeck){
		List<Card> deck = myDeck.getCurrentDeck();
		deck.forEach((n) -> System.out.println(n.getCard()));
	}
	//This method will shuffle the deck in a riffle like how we regularly shuffle
	//This is accomplished by picking a random number then taking that many off 
	//Of the top or bottom half of the deck until one half is gone the the rest are placed on
	private void shuffleOnceRandom(){
		//You need to have a copy of the deck before you shuffled it so you can reference
		//It when you are trying to replace the new values
		List<Card> beforeShuffle = ourDeck.makeCopy().getCurrentDeck();
		//The topIndex tells us where we are in reference to the top half of the deck
		//Same with bottom this helps us reference the original deck to get whatever
		//Card we need and the deckIndex helps us put it in the correct spot
		int topIndex = 0, bottomIndex = ourDeck.getSize() / 2, deckIndex = 0;
		//These ints help us keep track of how many cards are left in each half
		int remainingTop = ourDeck.getSize() / 2, remainingBot = ourDeck.getSize() / 2;
		boolean shouldLoop = true;
		//This is the shuffling loop
		while(shouldLoop){
			//This means the number coming from the specific deck which in this method is random
			int numTop = generator.nextInt(RAND_BOUND), numBot = generator.nextInt(RAND_BOUND);
			//After we determine the random number of cards we're using we have to do some checks
			//This means we wanted more than there was less therefore the stack is out
			//This is the stopping condition for the loop
			if(numTop >= remainingTop){
				numTop = remainingTop;
				numBot = remainingBot;
				shouldLoop = false;
			}
				
			if(numBot >= remainingBot){
				numTop = remainingTop;
				numBot = remainingBot;
				shouldLoop = false;
			}
			//This is where I replace the newCard into ourDeck
			//I iterate for the number of times we take from the top or bottom
			for(int i = 1; i <= numTop; i++){	
				Card newCard = beforeShuffle.get(topIndex);	//I get the card we want to move
				ourDeck.setCard(newCard, deckIndex);		//Then I move it to the new deckIndex
				topIndex++;	deckIndex++;
			}
			for(int i = 1; i <= numBot; i++){
				Card newCard = beforeShuffle.get(bottomIndex);
				ourDeck.setCard(newCard, deckIndex);
				bottomIndex++;	deckIndex++;
			}
			remainingTop = remainingTop - numTop;
			remainingBot = remainingBot - numBot;
		}
	}

	
}













