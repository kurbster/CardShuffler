import java.util.ArrayList;
import java.util.List;

public class PerfectShuffle {
	private List<Card> cards = new ArrayList<Card>(52);
	
	public PerfectShuffle(List<Card> start){
		cards = start;
	}
	
	//This method will keep calling the smaller
	//Shuffling method until the check method returns a true value,
	public List<Card> fullyShuffle(){
		List<Card> shuffledCards = shuffleOnce();
		return shuffledCards;
	}
	
	//Perform one round of shuffling
	//Which cuts the deck into 2 parts then shuffles
	//By taking one from a deck then another from the other
	private List<Card> shuffleOnce(){
		List<Card> deck1 = cards.subList(0, 26);
		List<Card> deck2 = cards.subList(26, 52);
		List<Card> newCards = new ArrayList<Card>(52);
		//This is the shuffling loop
		for(int i = 0; i < 26; i++){
			newCards.add(deck1.get(i));
			newCards.add(deck2.get(i));
			
		}
		return newCards;
	}
	
	private boolean checkFullyShuffled(){
		boolean shuffled = false;
		return shuffled;
	}
}