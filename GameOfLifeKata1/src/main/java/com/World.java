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
		return aliveNeightborsInNextRow(row, column)+ aliveNeightborsInPreviousRow(row, column) + aliveColumnNeightbors(row, column);
	}

	public World nextGeneration() {


		Cell[][] nextCellMatrix = new Cell[cellMatrix.length][cellMatrix[0].length];

		for (int rowIndex = 0; rowIndex < cellMatrix.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < cellMatrix[0].length; columnIndex++) {
				Cell cell = cellMatrix[rowIndex][columnIndex].regenerate(this.aliveNeighbors(rowIndex, columnIndex));
				nextCellMatrix[rowIndex][columnIndex] = cell;
			}
		}

		return new World(nextCellMatrix);
	}

	private int aliveNeightborsInPreviousRow(int row, int column) {
		int aliveNeightbors = 0;

		int previousRow = row - 1;

		if (previousRow >= 0) {

			if (isAliveCellAt(previousRow, column)) {
				aliveNeightbors++;
			}

			aliveNeightbors += this.aliveColumnNeightbors(previousRow, column);
		}
		return aliveNeightbors;
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
