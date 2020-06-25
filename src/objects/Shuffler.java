package objects;
import java.util.*;

public class Shuffler {
	private static final int RAND_BOUND = 4;
	private Random generator = new Random();
	private static Deck ourDeck;
	
	public Shuffler(Deck inputDeck){
		ourDeck = inputDeck;
	}
	//This method will keep calling the smaller
	//Shuffling method until the check method returns a true value,
	public void randomShuffle(){
		System.out.print("IAM THE FIRST TIME\n\n");
		printDeck(ourDeck);
		shuffleOnceRandom();
		System.out.print("AFTERSHUFFLE1\n\n");
		printDeck(ourDeck);
		shuffleOnceRandom();
		System.out.print("AFTERSHUFFLEadsfadsfasdfasdfsd1\n\n");
		printDeck(ourDeck);
	}
	
	//Perform one round of shuffling
	//Which cuts the deck into 2 parts then shuffles
	//By taking a random number of cards from one deck
	//Then a random number from the other
	private void shuffleOnceRandom(){
		List<Card> beforeShuffle = new ArrayList<Card>(ourDeck.getCurrentDeck());
		int topIndex = 0, bottomIndex = ourDeck.getSize() / 2, deckIndex = 0;
		int remainingTop = ourDeck.getSize() / 2, remainingBot = ourDeck.getSize() / 2;
		boolean shouldLoop = true;
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
				Card newCard = beforeShuffle.get(topIndex);
				ourDeck.setCard(newCard, deckIndex);
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
	
	private boolean checkFullyShuffled(){
		boolean shuffled = false;
		return shuffled;
	}
	
	private void printDeck(Deck myDeck){
		List<Card> deck = myDeck.getCurrentDeck();
		deck.forEach((n) -> System.out.println(n.getCard()));
	}
}













