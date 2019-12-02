package ms.Flugzeuge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardReader {

	public List<Card> getCards() {

		BufferedReader br = null;

		List<Card> cards = new ArrayList<>();

		File file = new File("E:\\SSD\\BBW\\3. Lehrjahr\\Semester 1\\Modul 411\\Flugzeuge\\GeneratedCards.txt");

		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line;
		try {
			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				String[] directions = line.split("/");

				cards.add(new Card(directions[0], directions[1], directions[2], directions[3]));

				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cards;

	}
}
