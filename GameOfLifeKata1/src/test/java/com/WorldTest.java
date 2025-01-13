package com;

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
	}
}
