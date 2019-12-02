package ms.Flugzeuge;

import java.util.LinkedList;
import java.util.List;

public class App {
	public static void main(String[] args) {

	}

	public List<Field> nextPossibleMoves(Field field, List<Card> remainingCards) {

		List<Field> fieldsWithOneMoreCard = new LinkedList<Field>();

		for (Card card : remainingCards) {
			Field addedUnturned = field.addedIfFits(card);
			if (addedUnturned != null) {
				fieldsWithOneMoreCard.add(addedUnturned);
			}
			for (int turn = 1; turn <= 3; turn++) {
				card = card.turned90DegreesClockwise();
				Field addedTurned = field.addedIfFits(card);
				if (addedTurned != null) {
					fieldsWithOneMoreCard.add(addedTurned);
				}
			}
		}

		return fieldsWithOneMoreCard;
	}

	public List<Field> findAllSolutions(Field field, List<Card> cards) {

		List<Field> solutions = new LinkedList<Field>();

		List<Field> nextPossibleMoves = nextPossibleMoves(field, cards);
		for (Field currentMove : nextPossibleMoves) {
			if (currentMove.isFull()) {
				solutions.add(currentMove);
			} else {
				List<Card> remaining = removed(currentMove.getLastCard(), cards);
				solutions.addAll(findAllSolutions(currentMove, remaining));
			}
		}

		return solutions;
	}

	private List<Card> removed(Object lastCard, List<Card> cards) {
		return null;
	}
}
