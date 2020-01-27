package ms.Flugzeuge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import ms.Flugzeuge.New.Board;
import ms.Flugzeuge.New.Coordinates;
import ms.Flugzeuge.New.Plane;

public class SolutionWriter {

	BufferedWriter writer = null;
	File logFile = new File("Solutions.txt");

	public void writeSolutions(ArrayList<Board> solutions) {
		try {
			if (logFile.exists() && logFile.isFile()) {
				logFile.delete();
				logFile.createNewFile();
			}

			System.out.println("Solutions File Location: " + logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));
			int solCounter = 1;
			for (Board board : solutions) {
				writer.write("Solution " + solCounter + ": ");
				writer.newLine();
				writer.write("----------------");
				writer.newLine();

				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						Coordinates coordinates = new Coordinates(x, y);
						Card card = board.getFields().get(coordinates);

						writer.write("Card-Coordinates: x=" + coordinates.getX() + "/y=" + coordinates.getY());
						writer.newLine();

						for (int i = 0; i < 4; i++) {
							Plane plane = null;
							String part = "Back";
							String direction = "";

							switch (i) {
							case 0:
								direction = "Up";
								plane = card.getUp();
								break;
							case 1:
								direction = "Right";
								plane = card.getRight();
								break;
							case 2:
								direction = "Down";
								plane = card.getDown();
								break;
							case 3:
								direction = "Left";
								plane = card.getLeft();
								break;
							}

							if (plane.isFrontPart()) {
								part = "Front";
							}

							writer.write(direction + ": " + part + "/" + plane.getColor());

							writer.newLine();
						}
						writer.newLine();
					}
				}

				solCounter++;
				writer.write("________________");
				writer.newLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				writer.close();
			} catch (Exception e) {
			}
		}
	}

	public void writeNoSolutions() {
		try {
			writer = new BufferedWriter(new FileWriter(logFile));
			System.out.println("Solutions File Location: " + logFile.getCanonicalPath());
			logFile.delete();
			logFile.createNewFile();
			writer.write("No solutions found!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}

	}

}
