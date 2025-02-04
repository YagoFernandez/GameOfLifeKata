package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**

  Método de creación
  Siguiente generación
  Nº de vecinos para una cooredenada determinada:
  [[Dead]] en coordenadas (0,0) -> 0
  [[Alive, Dead]] en coordenadas (0,1) -> 1
  [[Dead, Dead]] en coordenadas (0,1) -> 0
  [[Alive, Dead, Alive]] en coordenadas (0,1) -> 2
  [[Alive, Dead, Alive]
   [Alive, Alive, Alive]] en coordenadas (0,1) -> 5
   [Alive, Alive, Alive]
   [Alive, Dead, Alive]
   [Alive, Alive, Alive]] en coordenadas (1,1) -> 8

 */
public class WorldTest {

	@Test
	public void creates_a_cell_matrix_for_a_given_cell_status() {

		CellStatus[][] initialStatus = {
				{CellStatus.DEAD, CellStatus.DEAD},
				{CellStatus.DEAD, CellStatus.ALIVE}};

		World world = World.createFrom(initialStatus);

//		Cell[][] expectedWorld = {
//				{Cell.createDead(), Cell.createDead()},
//				{Cell.createDead(), Cell.createAlive()}};

		assertEquals(world.cellMatrix[0][0].status, CellStatus.DEAD);
		assertEquals(world.cellMatrix[0][1].status, CellStatus.DEAD);
		assertEquals(world.cellMatrix[1][0].status, CellStatus.DEAD);
		assertEquals(world.cellMatrix[1][1].status, CellStatus.ALIVE);
	}

	@Test
	public void gets_alive_neighbors_for_a_given_coordinates() {
		assertEquals(0, World.createFrom(new CellStatus[][] {{CellStatus.DEAD}}).aliveNeighbors(0, 0));
		assertEquals(1, World.createFrom(new CellStatus[][] {{CellStatus.ALIVE, CellStatus.DEAD}}).aliveNeighbors(0, 1));
		assertEquals(0, World.createFrom(new CellStatus[][] {{CellStatus.DEAD, CellStatus.DEAD}}).aliveNeighbors(0, 1));
		assertEquals(2, World.createFrom(new CellStatus[][] {{CellStatus.ALIVE, CellStatus.DEAD, CellStatus.ALIVE}}).aliveNeighbors(0, 1));
		assertEquals(0, World.createFrom(new CellStatus[][] {{CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD}}).aliveNeighbors(0, 1));

		assertEquals(5, World.createFrom(new CellStatus[][] {
			{CellStatus.ALIVE, CellStatus.DEAD, CellStatus.ALIVE},
			{CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE}}).aliveNeighbors(0, 1));

		assertEquals(8, World.createFrom(new CellStatus[][] {
			{CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE},
			{CellStatus.ALIVE, CellStatus.DEAD, CellStatus.ALIVE},
			{CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE}}).aliveNeighbors(1, 1));
	}

	@Test
	public void generates_the_next_state_of_the_game() {

		CellStatus[][] initialStatus = {
				{CellStatus.DEAD, CellStatus.ALIVE, CellStatus.DEAD},
				{CellStatus.DEAD, CellStatus.ALIVE, CellStatus.DEAD},
				{CellStatus.DEAD, CellStatus.ALIVE, CellStatus.DEAD}};

		World world = World.createFrom(initialStatus);

		Cell[][] nextState = world.nextGeneration().cellMatrix;

		/* EXPECTED
		{{CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD},
		 {CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE},
		 {CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD}}
		*/

		assertEquals(nextState[0][0].status, CellStatus.DEAD);
		assertEquals(nextState[0][1].status, CellStatus.DEAD);
		assertEquals(nextState[0][2].status, CellStatus.DEAD);
		assertEquals(nextState[1][0].status, CellStatus.ALIVE);
		assertEquals(nextState[1][1].status, CellStatus.ALIVE);
		assertEquals(nextState[1][2].status, CellStatus.ALIVE);
		assertEquals(nextState[2][0].status, CellStatus.DEAD);
		assertEquals(nextState[2][1].status, CellStatus.DEAD);
		assertEquals(nextState[2][2].status, CellStatus.DEAD);
	}

	@Test
	public void never_changes_for_a_given_initial_block_pattern() {

		CellStatus[][] initialStatus = {
				{CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.DEAD},
				{CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.DEAD},
				{CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD}};

		World world = World.createFrom(initialStatus);

		Cell[][] nextState = world.nextGeneration().nextGeneration().nextGeneration().cellMatrix;

		/* EXPECTED
		{{CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD},
		 {CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE},
		 {CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD}}
		*/

		assertEquals(nextState[0][0].status, CellStatus.ALIVE);
		assertEquals(nextState[0][1].status, CellStatus.ALIVE);
		assertEquals(nextState[0][2].status, CellStatus.DEAD);
		assertEquals(nextState[1][0].status, CellStatus.ALIVE);
		assertEquals(nextState[1][1].status, CellStatus.ALIVE);
		assertEquals(nextState[1][2].status, CellStatus.DEAD);
		assertEquals(nextState[2][0].status, CellStatus.DEAD);
		assertEquals(nextState[2][1].status, CellStatus.DEAD);
		assertEquals(nextState[2][2].status, CellStatus.DEAD);
	}
}
