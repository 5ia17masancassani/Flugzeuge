package ms.Flugzeuge.New;

import java.util.ArrayList;
import java.util.HashMap;

import ms.Flugzeuge.Card;

public class Board {
	private HashMap<Coordinates, Card> fields = new HashMap<>();

	public Board() {
		super();

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				fields.put(new Coordinates(x, y), null);
			}
		}
	}

	public ArrayList<Coordinates> getEmptyFields() {
		ArrayList<Coordinates> emptyFields = new ArrayList<>();

		for (Coordinates coordinates : fields.keySet()) {
			if (fields.get(coordinates) == null) {
				emptyFields.add(coordinates);
			}
		}

		return emptyFields;
	}

	public Boolean isValidBoard() {
		for (Coordinates coordinates : fields.keySet()) {
			Card card = fields.get(coordinates);

			if (card != null) {
				Coordinates newCoordinate;
				Card newCard;

				newCoordinate = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
				newCard = fields.get(newCoordinate);
				if (newCard != null && (card.getUp().getColor() != newCard.getDown().getColor()
						|| card.getUp().isFrontPart() == newCard.getDown().isFrontPart())) {
					return false;
				}

				newCoordinate = new Coordinates(coordinates.getX() + 1, coordinates.getY());
				newCard = fields.get(newCoordinate);
				if (newCard != null && (card.getRight().getColor() != newCard.getLeft().getColor()
						|| card.getRight().isFrontPart() == newCard.getLeft().isFrontPart())) {
					return false;
				}

				newCoordinate = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
				newCard = fields.get(newCoordinate);
				if (newCard != null && (card.getDown().getColor() != newCard.getUp().getColor()
						|| card.getDown().isFrontPart() == newCard.getUp().isFrontPart())) {
					return false;
				}

				newCoordinate = new Coordinates(coordinates.getX() - 1, coordinates.getY());
				newCard = fields.get(newCoordinate);
				if (newCard != null && (card.getLeft().getColor() != newCard.getRight().getColor()
						|| card.getLeft().isFrontPart() == newCard.getRight().isFrontPart())) {
					return false;
				}
			}
		}

		return true;
	}

	public Board copy() {
		Board newBoard = new Board();
		HashMap<Coordinates, Card> newFields = newBoard.getFields();

		for (Coordinates coordinates : fields.keySet()) {
			Card newCard = fields.get(coordinates);

			if (newCard != null) {
				newCard = newCard.copy();
			}

			newFields.put(coordinates.copy(), newCard);
		}

		return newBoard;
	}

	@Override
	public String toString() {
		return "Board [fields=" + fields + "]";
	}

	public HashMap<Coordinates, Card> getFields() {
		return fields;
	}

	public void setFields(HashMap<Coordinates, Card> fields) {
		this.fields = fields;
	}
}
