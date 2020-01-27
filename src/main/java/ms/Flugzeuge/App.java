package ms.Flugzeuge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ms.Flugzeuge.New.Board;
import ms.Flugzeuge.New.PlaneCalculator;

public class App {

	public static void main(String[] args) {

		RandomCardGenerator rcg = new RandomCardGenerator();
		CardReader reader = new CardReader();
		SolutionWriter solWriter = new SolutionWriter();
		rcg.generateRandomCards();
		ArrayList<Card> cards = reader.getCards();

		ArrayList<Board> solutions = PlaneCalculator.calculateSolution(new Board(), cards);

		if (solutions.size() > 0) {
			solWriter.writeSolutions(solutions);
			int count = 0;
			for (Board board : solutions) {
				count++;
			}
			System.out.println("Solutions: " + count);
			System.out.println("Solutions without turning: " + count/4);
		} else {
			solWriter.writeNoSolutions();
			System.out.println("No Solution Found!");
		}
	}
}
