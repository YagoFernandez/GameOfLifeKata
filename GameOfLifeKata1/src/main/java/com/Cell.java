package com;

public class Cell {

	private CellStatus status;

	public Cell(CellStatus status) {
		this.status = status;
	}

	public static Cell createAlive() {
		return new Cell(CellStatus.ALIVE);
	}

	public static Cell createDead() {
		return new Cell(CellStatus.DEAD);
	}

	public Cell regenerate(int numberOfNeightbors) {
		CellStatus nextStatus = CellStatus.ALIVE == this.status
				? statusForAliveCell(numberOfNeightbors)
				: statusForDeadCell(numberOfNeightbors);

		return new Cell(nextStatus);
	}

	public boolean isAlive() {
		return CellStatus.ALIVE.equals(status);
	}


	private CellStatus statusForAliveCell(int numberOfNeightbors) {
		return isStablePopulation(numberOfNeightbors)
				? CellStatus.ALIVE
				: CellStatus.DEAD;
	}

	private boolean isStablePopulation(int numberOfNeightbors) {
		return 2 == numberOfNeightbors || isFertilePopulation(numberOfNeightbors);
	}

	private CellStatus statusForDeadCell(int numberOfNeightbors) {
		return isFertilePopulation(numberOfNeightbors)
				? CellStatus.ALIVE
				: CellStatus.DEAD;
	}

	private boolean isFertilePopulation(int numberOfNeightbors) {
		return 3 == numberOfNeightbors;
	}

}
