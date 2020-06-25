package objects;
import java.util.*;

public class Shuffler {
	private static final int RAND_BOUND = 4;
	private Random generator = new Random();
	
	//This method will keep calling the smaller
	//Shuffling method until the check method returns a true value,
	public void randomShuffle(Deck currentDeck){
		System.out.print("IAM THE FIRST TIME\n\n");
		printDeck(currentDeck);
		shuffleOnceRandom(currentDeck);
		System.out.print("IAM THE LAST TIME\n\n");
		printDeck(currentDeck);
		shuffleOnceRandom(currentDeck);
	}
	
	//Perform one round of shuffling
	//Which cuts the deck into 2 parts then shuffles
	//By taking a random number of cards from one deck
	//Then a random number from the other
	private void shuffleOnceRandom(Deck cards){
		int topIndex = 0, bottomIndex = cards.getSize() / 2, deckIndex = 0;
		int remainingTop = cards.getSize() / 2, remainingBot = cards.getSize() / 2;
		boolean shouldLoop = true;
		System.out.print("IAM THE BEFORE WHILE LOOP\n\n");
		printDeck(cards);
		//This is the shuffling loop
		while(shouldLoop){
			//This means the number coming from the specific deck which in this method is random
			int numTop = generator.nextInt(RAND_BOUND), numBot = generator.nextInt(RAND_BOUND);
			//After we determine the random number of cards we're using we have to do some checks
			//This means we wanted more than there was less therefore the stack is out
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
			
			for(int i = 1; i <= numTop; i++){
				Card newCard = cards.getCard(topIndex);
				cards.setCard(newCard, deckIndex);
				topIndex++;	deckIndex++;
			}
			for(int i = 1; i <= numBot; i++){
				Card newCard = cards.getCard(bottomIndex);
				cards.setCard(newCard, deckIndex);
				bottomIndex++;	deckIndex++;
			}
			remainingTop = remainingTop - numTop;
			remainingBot = remainingBot - numBot;
		}
		System.out.print("IAM THE AFTER WHILEL \n\n");
		printDeck(cards);
	}
	
	private boolean checkFullyShuffled(){
		boolean shuffled = false;
		return shuffled;
	}
	
	private void printDeck(Deck myDeck){
		List<Card> deck = myDeck.getCurrentDeck();
		deck.forEach((n) -> System.out.println(n.getCard()));
	}
}













