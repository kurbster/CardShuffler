package input_output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import objects.Card;
import objects.Deck;

public class OutputManager {
	public void writeFile(Deck startDeck, Deck endDeck){
		//This string helps us format the output for it looks pretty
		String formatter = "%-3.3s %-3.3s%n";
		try{
			//Here I am creating the new file and checking if it already exists
			File myFile = new File("output/name.txt");
			if(!myFile.exists())
				myFile.createNewFile();
			//Here I se up the writing objects
			FileWriter fw = new FileWriter(myFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//As I loop through the start deck I need an iterator to go through the end deck
			ListIterator<Card> cardItr = endDeck.getCurrentDeck().listIterator();
			startDeck.getCurrentDeck().forEach((card) -> {
				//Here I am writing to the file using the formatter above
				Card endCard = cardItr.next();
				try {
					bw.write(String.format(formatter, card.getCard(), endCard.getCard()));
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