package ms.Flugzeuge;

import java.util.LinkedList;
import java.util.List;

public class App {

// 0=vorne, 1=hinten
// 0=rot, 1=grün, 2=blau	

	public static void main(String[] args) {

		RandomCardGenerator rcg = new RandomCardGenerator();
		CardReader reader = new CardReader();
		rcg.generateRandomCards();
		List<Card> cards = reader.getCards();
		
		List<Field> solutions = findAllSolutions(new Field(), cards);
		System.out.println("_________________________");
		
		for(Field field : solutions) {
			System.out.println(field.getCurrentCard().getUp() + "/" + field.getCurrentCard().getRight() + "/" +field.getCurrentCard().getDown() + "/" +field.getCurrentCard().getLeft());
		}
	}

	public static List<Field> nextPossibleMoves(Field field, List<Card> remainingCards) {

		List<Field> fieldsWithOneMoreCard = new LinkedList<Field>();

		for (Card card : remainingCards) {
			Field addedUnturned = field.addIfFits(card);
			if (addedUnturned != null) {
				fieldsWithOneMoreCard.add(addedUnturned);
			}
			for (int turn = 1; turn <= 3; turn++) {
				card = card.turned90DegreesClockwise();
				Field addedTurned = field.addIfFits(card);
				if (addedTurned != null) {
					fieldsWithOneMoreCard.add(addedTurned);
				}
			}
		}

		return fieldsWithOneMoreCard;
	}

	public static List<Field> findAllSolutions(Field field, List<Card> cards) {

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

	private static List<Card> removed(Card lastCard, List<Card> cards) {

		cards.remove(lastCard);

		return cards;
	}
}
