package ms.Flugzeuge;

public class Card {

	private String up;
	private String right;
	private String down;
	private String left;

	public Card(String up, String right, String down, String left) {
		super();
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getDown() {
		return down;
	}

	public void setDown(String down) {
		this.down = down;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public Card turned90DegreesClockwise() {
		String tempUp = this.up;
		String tempRight = this.right;
		String tempDown = this.down;
		String tempLeft = this.left;

		this.up = tempLeft;
		this.right = tempUp;
		this.down = tempRight;
		this.left = tempDown;

		return this;
	}

}
