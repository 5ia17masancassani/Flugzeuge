package ms.Flugzeuge.New;

public class Plane {
	private Boolean isFrontPart;
	private Color color;

	public Plane(boolean isFrontPart, Color color) {
		super();
		this.isFrontPart = isFrontPart;
		this.color = color;
	}

	public Plane copy() {
		return new Plane(isFrontPart, color);
	}

	@Override
	public String toString() {
		return "Plane [isFrontPart=" + isFrontPart + ", color=" + color + "]";
	}

	public Boolean isFrontPart() {
		return isFrontPart;
	}

	public void setFrontPart(Boolean isFrontPart) {
		this.isFrontPart = isFrontPart;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
