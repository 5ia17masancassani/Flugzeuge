package ms.Flugzeuge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class RandomCardGenerator {

	public void generateRandomCards() {

		BufferedWriter writer = null;
		Random random = new Random();
		try {
			File logFile = new File("GeneratedCards");

			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));
			for (int i = 0; i < 9; i++) {
				writer.write(random.nextInt(2) + "," + random.nextInt(3) + "/" + random.nextInt(2) + ","
						+ random.nextInt(3) + "/" + random.nextInt(2) + "," + random.nextInt(3) + "/"
						+ random.nextInt(2) + "," + random.nextInt(3));
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

}
