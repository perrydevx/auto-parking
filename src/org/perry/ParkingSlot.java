package org.perry;

public class ParkingSlot {
	private int x;
	private int y;

	public ParkingSlot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return y + "," + x;
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
}
