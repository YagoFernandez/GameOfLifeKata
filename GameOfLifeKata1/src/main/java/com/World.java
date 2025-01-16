package com;

public class World {

	public Cell[][] cellMatrix;

	private World(Cell[][] cellmatrix) {
		this.cellMatrix = cellmatrix;
	}

	public static World createFrom(CellStatus[][] cellStatus) {

		Cell[][] cellmatrix = new Cell[cellStatus.length][cellStatus[0].length];

		for (int i=0; i < cellStatus.length; i++) {
			for (int j=0; j < cellStatus[i].length; j++) {
				cellmatrix[i][j] = new Cell(cellStatus[i][j]);
			}
		}

		return new World(cellmatrix);
	}

	public int aliveNeighbors(int row, int column) {
		return aliveNeightborsInNextRow(row, column) + aliveColumnNeightbors(row, column);
	}

	private int aliveNeightborsInNextRow(int row, int column) {
		int aliveNeightbors = 0;

		int nextRow = row + 1;

		if (nextRow < cellMatrix.length) {

			if (isAliveCellAt(nextRow, column)) {
				aliveNeightbors++;
			}

			aliveNeightbors += this.aliveColumnNeightbors(nextRow, column);
		}
		return aliveNeightbors;
	}

	private int aliveColumnNeightbors(int row, int column) {
		int aliveNeightbors = 0;

		int previousColumn = column - 1;

		if (previousColumn >= 0 && isAliveCellAt(row, previousColumn)) {
			aliveNeightbors++;
		}

		int nextColumn = column + 1;
		int rowLength = cellMatrix[row].length;

		if (nextColumn < rowLength && isAliveCellAt(row, nextColumn)) {
			aliveNeightbors++;
		}
		return aliveNeightbors;
	}

	private boolean isAliveCellAt(int row, int column) {
		return cellMatrix[row][column].isAlive();
	}
}
