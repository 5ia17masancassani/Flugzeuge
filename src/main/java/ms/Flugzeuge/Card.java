package ms.Flugzeuge;

import ms.Flugzeuge.New.Plane;

public class Card {
	private Plane up;
	private Plane right;
	private Plane down;
	private Plane left;

	public Card(Plane up, Plane right, Plane down, Plane left) {
		super();
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
	}

	public Card copy() {
		return new Card(up.copy(), right.copy(), down.copy(), left.copy());
	}

	@Override
	public String toString() {
		return "Card [up=" + up + ", right=" + right + ", down=" + down + ", left=" + left + "]";
	}

	public Plane getUp() {
		return up;
	}

	public void setUp(Plane up) {
		this.up = up;
	}

	public Plane getRight() {
		return right;
	}

	public void setRight(Plane right) {
		this.right = right;
	}

	public Plane getDown() {
		return down;
	}

	public void setDown(Plane down) {
		this.down = down;
	}

	public Plane getLeft() {
		return left;
	}

	public void setLeft(Plane left) {
		this.left = left;
	}

	public void turned90DegreesClockwise() {
		Plane tempUp = this.up;
		Plane tempRight = this.right;
		Plane tempDown = this.down;
		Plane tempLeft = this.left;

		this.up = tempLeft;
		this.right = tempUp;
		this.down = tempRight;
		this.left = tempDown;
	}

}
