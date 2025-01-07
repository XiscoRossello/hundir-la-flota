# Hundir la Flota

"Hundir la Flota" es un juego de Batalla Naval implementado en Java. El objetivo del juego es hundir todos los barcos del oponente antes de que se agoten los disparos. El juego permite al usuario seleccionar un modo de juego personalizado o elegir entre tres niveles de dificultad (Fácil, Medio, Difícil).

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de archivos:

.
├── Main
├── Barcos
├── Disparos
└── Tablero

### Archivos y Descripción

#### `Main.java`

Este archivo contiene la clase principal del programa y maneja la lógica del juego, incluyendo la configuración inicial, la selección de dificultad, y el bucle principal del juego. Aquí se inicializan el tablero y los barcos, y se controla el flujo del juego hasta que se hunden todos los barcos o se agotan los disparos.

#### `Disparos.java`

Este archivo contiene la lógica para manejar los disparos del jugador. Incluye métodos para seleccionar y realizar disparos, verificar aciertos y actualizar el tablero. También controla el número máximo de disparos permitidos según la dificultad seleccionada.

#### `Barcos.java`

Este archivo define las clases `Barco` y `Posicion`, y contiene la lógica para insertar barcos en el tablero. Incluye métodos para verificar solapamientos y convertir letras de fila en índices. Los barcos se insertan de manera aleatoria en el tablero, asegurando que no se solapen.

#### `Tablero.java`

Este archivo define la clase `Tablero`, que maneja la representación del tablero de juego. Incluye métodos para imprimir el tablero, actualizarlo con disparos y mostrar las posiciones de los barcos al final del juego. El tablero se representa como una matriz de cadenas, donde cada celda puede contener agua, un barco, un acierto o un fallo.

## Cómo Jugar

1. Al iniciar el juego, se pregunta al usuario si desea un modo de juego personalizado o seleccionar un nivel de dificultad.
2. En el modo personalizado, el usuario ingresa la cantidad de cada tipo de barco y el número máximo de disparos.
3. En el modo de dificultad, el usuario selecciona entre Fácil, Medio y Difícil, y los parámetros del juego se ajustan automáticamente.
4. El tablero de 10x10 se crea y se insertan los barcos según los parámetros seleccionados.
5. El usuario realiza disparos ingresando las coordenadas (fila y columna) hasta que se hunden todos los barcos o se agotan los disparos.
6. Al final del juego, se muestra el tablero con las posiciones de los barcos para que el jugador vea dónde estaban ubicados.

¡Disfruta jugando a "Hundir la Flota"!
