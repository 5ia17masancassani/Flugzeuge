package ms.Flugzeuge;

public class Field {

	private Card currentCard;
	private Card lastCard;

	public Field addIfFits(Card card) {

		if (this.currentCard == null) {
			this.currentCard = card;
		} else {
			this.lastCard = this.currentCard;
			this.currentCard = card;
		}
		return this;
	}

	public boolean isFull() {
		if (this.currentCard == null) {
			return false;
		} else {
			return true;
		}

	}

	public Card getLastCard() {
		return this.lastCard;
	}

	public Card getCurrentCard() {
		return this.currentCard;
	}

}
