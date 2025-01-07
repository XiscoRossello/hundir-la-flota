import java.util.ArrayList;

public class Tablero {
    private String[][] tablero;

    public Tablero(int filas, int columnas) {
        tablero = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = "-";  
            }
        }
    }

    public String[][] getTablero() {
        return tablero;
    }

    // Imprimir el tablero
    public void imprimirTablero() {
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char)('A' + i) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Actualizar el tablero con los disparos
    public void actualizarTablero(int fila, int columna, String valor) {
        tablero[fila][columna] = valor;
    }

    // Actualizar el tablero con las posiciones de los barcos
    public void mostrarPosicionesBarcos(ArrayList<Barcos.Barco> barcos) {
        for (Barcos.Barco barco : barcos) {
            String simbolo;
            switch (barco.getTipo()) {
                case "Lancha":
                    simbolo = "L";
                    break;
                case "Buque":
                    simbolo = "B";
                    break;
                case "Acorazado":
                    simbolo = "A";
                    break;
                case "Portaaviones":
                    simbolo = "P";
                    break;
                default:
                    simbolo = "?";
            }
            for (Barcos.Posicion posicion : barco.getPosiciones()) {
                tablero[posicion.fila][posicion.columna] = simbolo;
            }
        }
    }
}