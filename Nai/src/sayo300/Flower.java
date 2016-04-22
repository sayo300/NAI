package sayo300;

public class Flower {

	private double[] x;
	private String kindOfFlower;
	private int[] y;

	public String getKindOfFlower() {
		return kindOfFlower;
	}

	public void setKindOfFlower(String kindOfFlower) {
		this.kindOfFlower = kindOfFlower;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public double[] getX() {
		return x;
	}

	public void setX(double[] x) {
		this.x = x;
	}

	public Flower(double[] x, String kindOfFlower) {
		super();
		this.x = x;
		this.kindOfFlower = kindOfFlower;
	}

	

	@Override
	public String toString() {
		return "Flower [kindOfFlower=" + kindOfFlower + "]";
	}

}
