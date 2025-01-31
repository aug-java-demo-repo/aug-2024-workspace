package generics;

public class Box {
	private int length;
	private int breadth;
	private int height;
	
	public Box(int length, int breadth, int height) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Box [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
}
