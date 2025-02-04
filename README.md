# Conway's Game of Life Kata

Este proyecto implementa una versión de la famosa simulación del **Game of Life** de John Conway como una kata de programación.

## Descripción
El **Game of Life** es un autómata celular diseñado por el matemático británico John Horton Conway. Se desarrolla en una rejilla infinita de celdas cuadradas, donde cada celda puede estar viva o muerta. El juego evoluciona en pasos discretos según unas simples reglas que determinan el estado de cada celda en el siguiente paso.

### Reglas del juego
1. Una celda viva con menos de 2 celdas vivas vecinas muere (por baja densidad).
2. Una celda viva con 2 o 3 celdas vivas vecinas sobrevive.
3. Una celda viva con más de 3 celdas vivas vecinas muere (por sobrepoblación).
4. Una celda muerta con exactamente 3 celdas vivas vecinas vuelve a la vida.

## Objetivo del Proyecto
El objetivo de esta kata es proporcionar una forma divertida y desafiante de practicar el diseño, desarrollo y prueba de algoritmos, siguiendo buenas prácticas de programación y desarrollo guiado por pruebas (TDD).

## Estructura del Proyecto
- `src/`: Contiene el código fuente del proyecto.
- `tests/`: Contiene las pruebas automatizadas.
- `README.md`: Este archivo de documentación.

## Tecnologías
Este proyecto está desarrollado con:
- Lenguaje: Java
- Herramientas de prueba: JUnit


