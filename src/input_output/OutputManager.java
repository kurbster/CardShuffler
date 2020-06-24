package input_output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import objects.Card;

public class OutputManager {
	public void writeFile(List<Card> startDeck, List<Card> endDeck, String shufflingName){
		String formatter = "%-1s %-1s %-5s %-1s%n";
		try{
			File myFile = new File("output/name.txt");
			if(!myFile.exists())
				myFile.createNewFile();
			FileWriter fw = new FileWriter(myFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			ListIterator<Card> cardItr = endDeck.listIterator();
			startDeck.forEach((card) -> {
				Card endCard = cardItr.next();
				try {
					bw.write(String.format(formatter, card.getValue(), card.getSuit(), endCard.getValue(), endCard.getSuit()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			bw.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}