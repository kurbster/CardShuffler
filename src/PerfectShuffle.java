import java.util.*;

public class PerfectShuffle {
	private static final int RAND_BOUND = 4;
	private List<Card> cards = new ArrayList<Card>(52);
	private Random generator = new Random();
	
	public PerfectShuffle(List<Card> start){
		cards = start;
	}
	
	//This method will keep calling the smaller
	//Shuffling method until the check method returns a true value,
	public List<Card> fullyShuffle(){
		shuffleOnce(); shuffleOnce(); shuffleOnce();
		shuffleOnce(); shuffleOnce(); shuffleOnce();
		shuffleOnce(); shuffleOnce(); shuffleOnce();
		shuffleOnce(); shuffleOnce(); shuffleOnce();
		shuffleOnce(); shuffleOnce(); shuffleOnce();
		shuffleOnce(); shuffleOnce(); shuffleOnce();
		List<Card> shuffledCards = shuffleOnce();
		return shuffledCards;
	}
	
	//Perform one round of shuffling
	//Which cuts the deck into 2 parts then shuffles
	//By taking a random number of cards from one deck
	//Then a random number from the other
	private List<Card> shuffleOnce(){
		List<Card> d1 = cards.subList(0, 26); 
		List<Card> d2 = cards.subList(26, 52);
		List<Card> deck1 = new ArrayList<Card>(d1);
		List<Card> deck2 = new ArrayList<Card>(d2);
		List<Card> newCards = new ArrayList<Card>(52);
		int remainingD1 = 26, remainingD2 = 26;
		//This is the shuffling loop
		while(!deck1.isEmpty() && !deck2.isEmpty()){
			int n1 = generator.nextInt(RAND_BOUND), n2 = generator.nextInt(RAND_BOUND);
			//After we determine the random number of cards we're using we have to do some checks
			//This means we wanted more than there was less therefore the stack is out
			if(n1 >= remainingD1){
				n1 = remainingD1;
				n2 = remainingD2;
			}
				
			if(n2 >= remainingD2){
				n1 = remainingD1;
				n2 = remainingD2;
			}
				
			for(int i = 1; i <= n1; i++)
				newCards.add(deck1.remove(0));
			for(int i = 1; i <= n2; i++)
				newCards.add(deck2.remove(0));
			remainingD1 = remainingD1 - n1;
			remainingD2 = remainingD2 - n2;
		}
		cards = newCards;
		return newCards;
	}
	
	private boolean checkFullyShuffled(){
		boolean shuffled = false;
		return shuffled;
	}
}













