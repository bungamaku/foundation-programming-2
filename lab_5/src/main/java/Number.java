public class Number {

	private int value;
	private int x;
	private int y;
	private boolean isChecked;

	public Number(int value, int x, int y) {
		super();
		this.value = value;
		this.x = x;
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

}
