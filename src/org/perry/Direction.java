package org.perry;

public enum Direction {
	LEFT('L'), RIGHT('R');

	Direction(char c) {
		this.turn = c;
	}

	private final char turn;

	public char getTurn() {
		return turn;
	}
}
