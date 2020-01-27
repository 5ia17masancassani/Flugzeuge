package ms.Flugzeuge.New;

import java.util.ArrayList;

import ms.Flugzeuge.Card;

public class PlaneCalculator {
	public static ArrayList<Board> calculateSolution(Board board, ArrayList<Card> cards) {
		ArrayList<Board> solutionBoards = new ArrayList<>();

		if (cards.size() == 0) {
			if (board.isValidBoard()) {
				solutionBoards.add(board);
			}
			return solutionBoards;
		}

		Card cardToSet = cards.get(0);
		cards.remove(cardToSet);

		for (Coordinates coordinates : board.getEmptyFields()) {
			for (int i = 0; i < 4; i++) {
				Board newBoard = board.copy();
				newBoard.getFields().put(coordinates.copy(), cardToSet.copy());

				ArrayList<Card> newCards = new ArrayList<>();
				for (Card card : cards) {
					newCards.add(card.copy());
				}

				if (board.isValidBoard()) {
					solutionBoards.addAll(calculateSolution(newBoard, newCards));
				}

				cardToSet.turned90DegreesClockwise();
			}
		}

		return solutionBoards;
	}
}
