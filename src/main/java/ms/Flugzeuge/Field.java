package ms.Flugzeuge;

import java.util.HashMap;

public class Field {

	private Card[][] cards = new Card[3][3];
	private HashMap<String, Card> cardHistory = new HashMap<>();

	private int x = 0;
	private int y = 0;

	public Field addIfFits(Card card) {

		if (x == 0 && y == 0) {
			this.cards[x][y] = card;
			cardHistory.put(x + " " + y, card);
			System.out.println("Added card on:" + x + " " + y);

		} else if (x == 1 && y == 0 || x == 2 && y == 0) {

			if (x == 1) {
				String leftCard[] = cardHistory.get("0 0").getRight().split(",");
				String rightCard[] = card.getLeft().split(",");

				if (leftCard[0] != rightCard[0] && leftCard[1] == rightCard[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			} else {
				String leftCard[] = cardHistory.get("1 0").getRight().split(",");
				String rightCard[] = card.getLeft().split(",");

				if (leftCard[0] != rightCard[0] && leftCard[1] == rightCard[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			}

		} else if (x == 0 && y == 1 || x == 0 && y == 2) {

			if (y == 1) {
				String upCard[] = cardHistory.get("0 0").getDown().split(",");
				String downCard[] = card.getUp().split(",");

				if (upCard[0] != downCard[0] && upCard[1] == downCard[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			} else {
				String upCard[] = cardHistory.get("0 1").getDown().split(",");
				String downCard[] = card.getUp().split(",");

				if (upCard[0] != downCard[0] && upCard[1] == downCard[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			}

		} else if (x == 1 && y == 1 || x == 2 && y == 1 || x == 1 && y == 2 || x == 2 && y == 2) {

			if (x == 1 && y == 1) {
				String leftCard[] = cardHistory.get("0 1").getRight().split(",");
				String upCard[] = cardHistory.get("1 0").getDown().split(",");
				String middleCardUp[] = card.getUp().split(",");
				String middleCardLeft[] = card.getLeft().split(",");

				if (leftCard[0] != middleCardLeft[0] && leftCard[1] == middleCardLeft[1] && upCard[0] != middleCardUp[0]
						&& upCard[1] == middleCardUp[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			} else if (x == 2 && y == 1) {
				String leftCard[] = cardHistory.get("1 1").getRight().split(",");
				String upCard[] = cardHistory.get("2 0").getDown().split(",");
				String middleCardUp[] = card.getUp().split(",");
				String middleCardLeft[] = card.getLeft().split(",");

				if (leftCard[0] != middleCardLeft[0] && leftCard[1] == middleCardLeft[1] && upCard[0] != middleCardUp[0]
						&& upCard[1] == middleCardUp[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			} else if (x == 1 && y == 2) {
				String leftCard[] = cardHistory.get("0 2").getRight().split(",");
				String upCard[] = cardHistory.get("1 1").getDown().split(",");
				String middleCardUp[] = card.getUp().split(",");
				String middleCardLeft[] = card.getLeft().split(",");

				if (leftCard[0] != middleCardLeft[0] && leftCard[1] == middleCardLeft[1] && upCard[0] != middleCardUp[0]
						&& upCard[1] == middleCardUp[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			} else if (x == 2 && y == 2) {
				String leftCard[] = cardHistory.get("1 2").getRight().split(",");
				String upCard[] = cardHistory.get("2 1").getDown().split(",");
				String middleCardUp[] = card.getUp().split(",");
				String middleCardLeft[] = card.getLeft().split(",");

				if (leftCard[0] != middleCardLeft[0] && leftCard[1] == middleCardLeft[1] && upCard[0] != middleCardUp[0]
						&& upCard[1] == middleCardUp[1]) {
					this.cards[x][y] = card;
					cardHistory.put(x + " " + y, card);
					System.out.println("Added card on:" + x + " " + y);

				} else {

				}

			}

		}

		moveForwards();

		return this;
	}

	public void moveForwards() {
		if (this.x != 2 && this.y != 2) {
			if (this.x == 2) {
				this.x = 0;
				this.y++;
			} else {
				this.x++;
			}
		}

	}

	public void moveBackwards() {

		if (this.x != 0 && this.y != 0) {
			if (this.x == 0) {
				this.x = 2;
				this.y--;
			} else {
				this.x--;
			}
		}

	}

	public boolean isFull() {
		return false;

	}

	public Card getLastCard() {
		return null;
	}

}
