package ms.Flugzeuge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ms.Flugzeuge.New.Color;
import ms.Flugzeuge.New.Plane;

public class CardReader {

	public ArrayList<Card> getCards() {

		BufferedReader br = null;

		ArrayList<Card> cards = new ArrayList<>();

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
				String[] directions = line.split("/");

				Plane up = createPlane(directions[0]);
				Plane right = createPlane(directions[1]);
				Plane down = createPlane(directions[2]);
				Plane left = createPlane(directions[3]);

				cards.add(new Card(up, right, down, left));

				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cards;

	}

	private Plane createPlane(String string) {
		Boolean isFrontPart = null;
		Color color = null;
		String[] parts = string.split(",");

		switch (parts[0]) {
		case "0":
			isFrontPart = true;
			break;
		case "1":
			isFrontPart = false;
			break;
		}

		switch (parts[1]) {
		case "0":
			color = Color.Red;
			break;
		case "1":
			color = Color.Green;
			break;
		case "2":
			color = Color.Blue;
			break;
		}

		return new Plane(isFrontPart, color);
	}
}
