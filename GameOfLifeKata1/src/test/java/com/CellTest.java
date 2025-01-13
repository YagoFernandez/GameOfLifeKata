package com;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTest {

	@Test
	public void any_live_cell_with_fewer_than_two_live_neightborgs_dies() {
		assertFalse(Cell.createAlive().regenerate(1).isAlive());
		assertFalse(Cell.createDead().regenerate(1).isAlive());
	}

	@Test
	public void any_live_cell_with_two_or_three_live_neightbors_lives() {
		assertTrue(Cell.createAlive().regenerate(2).isAlive());
		assertTrue(Cell.createAlive().regenerate(3).isAlive());
		assertFalse(Cell.createDead().regenerate(2).isAlive());
	}

	@Test
	public void any_live_cell_with_more_than_three_live_neightbors_dies() {
		assertFalse(Cell.createAlive().regenerate(4).isAlive());
		assertFalse(Cell.createDead().regenerate(4).isAlive());
	}

	@Test
	public void any_dead_cell_with_exactly_3_live_neightbors_becomes_a_live_cell() {
		assertTrue(Cell.createDead().regenerate(3).isAlive());
	}

}
