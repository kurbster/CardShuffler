package objects;

public class Card {
	private String value;
	private String suit;
	
	public Card(String val, String s){
		value = val;
		suit = s;
	}
	public String getCard(){
		return value + suit;
	}
}
