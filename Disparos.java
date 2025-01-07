import java.util.ArrayList;
import java.util.Scanner;

public class Disparos {

    // Variables para controlar el número máximo de disparos y el número actual de disparos
    private static int maxDisparos;
    private static int disparosRestantes;

    // Método para establecer el número máximo de disparos según la dificultad
    public static void establecerMaxDisparos(int maxDisparos) {
        Disparos.maxDisparos = maxDisparos;
        disparosRestantes = maxDisparos;
    }

    // Método para seleccionar y realizar un disparo
    public static boolean seleccionarDisparo(ArrayList<Barcos.Barco> barcos, Tablero miTablero) {
        // Verificar si el jugador ha agotado los disparos
        if (disparosRestantes <= 0) {
            System.out.println("¡Se han agotado tus disparos!");
            return true; // Terminar el juego si ya no quedan disparos
        }

        Scanner disparo = new Scanner(System.in);

        // Pedir la fila (letra) y asegurarse de que esté en el rango adecuado
        System.out.println("Selecciona la FILA (letra) para dirigir tu disparo (A, B, C...):");
        char filaDisparo = disparo.nextLine().toUpperCase().charAt(0);
        int filaDisparoIndex = Barcos.convertirFila(filaDisparo);
        
        if (filaDisparoIndex < 0 || filaDisparoIndex >= miTablero.getTablero().length) {
            System.out.println("Fila fuera del rango. Intenta de nuevo.");
            return false;  // Salir del método si la fila no es válida
        }

        // Pedir la columna (número) y asegurarse de que esté dentro del rango adecuado
        System.out.println("Selecciona la COLUMNA para dirigir tu disparo (0, 1, 2...):");
        int columnaDisparo = disparo.nextInt();  // No es necesario restar 1 ya que ahora es 0-indexed
        
        if (columnaDisparo < 0 || columnaDisparo >= miTablero.getTablero()[0].length) {
            System.out.println("Columna fuera del rango. Intenta de nuevo.");
            return false;  // Salir del método si la columna no es válida
        }

        // Comprobar si el disparo acierta o falla
        boolean acierto = comprobarDisparo(filaDisparoIndex, columnaDisparo, barcos);

        // Actualizar el tablero con X o 0 dependiendo del acierto
        if (acierto) {
            System.out.println("¡Acierto!");
            miTablero.actualizarTablero(filaDisparoIndex, columnaDisparo, "X");
        } else {
            System.out.println("Fallo.");
            miTablero.actualizarTablero(filaDisparoIndex, columnaDisparo, "0");
        }

        // Imprimir el tablero actualizado
        miTablero.imprimirTablero();

        // Decrementar el contador de disparos restantes
        disparosRestantes--;
        System.out.println("Disparos restantes: " + disparosRestantes);

        // Verificar si se han agotado los disparos
        if (disparosRestantes <= 0) {
            System.out.println("¡Se han agotado tus disparos!");
            return true; // Terminar el juego si ya no quedan disparos
        }

        return false;
    }

    // Método para comprobar si el disparo es un acierto
    public static boolean comprobarDisparo(int fila, int columna, ArrayList<Barcos.Barco> barcos) {
        for (Barcos.Barco barco : barcos) {
            for (Barcos.Posicion posicion : barco.getPosiciones()) {
                if (posicion.fila == fila && posicion.columna == columna) {
                    return true;  // El disparo ha acertado
                }
            }
        }
        return false;  // El disparo ha fallado
    }
}

