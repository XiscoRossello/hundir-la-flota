import java.util.ArrayList;
import java.util.Random;

public class Barcos {

    // Clase interna Posicion que almacena las coordenadas fila y columna de un barco
    public static class Posicion {
        int fila;
        int columna;

        public Posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }
    }

    // Clase interna Barco que almacena un barco y sus posiciones
    public static class Barco {
        private ArrayList<Posicion> posiciones;
        private String tipo;

        public Barco(String tipo, ArrayList<Posicion> posiciones) {
            this.tipo = tipo;
            this.posiciones = posiciones;
        }

        public ArrayList<Posicion> getPosiciones() {
            return posiciones;
        }

        public String getTipo() {
            return tipo;
        }
    }

    // Método para insertar barcos en el tablero, con verificación de solapamiento
    public static ArrayList<Barco> insertarBarcos(int filas, int columnas, int lanchas, int buques, int acorazados, int portaaviones) {
        ArrayList<Barco> barcos = new ArrayList<>();
        Random rand = new Random();

        // Tablero donde se marcan las posiciones ocupadas
        boolean[][] tableroOcupado = new boolean[filas][columnas];

        // Insertar las lanchas
        for (int i = 0; i < lanchas; i++) {
            ArrayList<Posicion> posiciones = new ArrayList<>();
            int posicionx, posiciony;
            do {
                posicionx = rand.nextInt(filas);
                posiciony = rand.nextInt(columnas);
            } while (tableroOcupado[posicionx][posiciony]);  // Verificar si ya está ocupado

            posiciones.add(new Posicion(posicionx, posiciony));
            barcos.add(new Barco("Lancha", posiciones));
            tableroOcupado[posicionx][posiciony] = true;  // Marcar como ocupado
        }

        // Insertar los buques de 3x3 horizontal
        for (int i = 0; i < buques; i++) {
            ArrayList<Posicion> posiciones = new ArrayList<>();
            int posicionx, posiciony;
            do {
                posicionx = rand.nextInt(filas);
                posiciony = rand.nextInt(columnas - 2);  // Asegurarse de que haya espacio para el barco de 3x3
            } while (comprobarSolapamiento(posicionx, posiciony, 3, tableroOcupado));  // Verificar solapamiento

            for (int j = 0; j < 3; j++) {
                posiciones.add(new Posicion(posicionx, posiciony + j));
                tableroOcupado[posicionx][posiciony + j] = true;  // Marcar como ocupado
            }
            barcos.add(new Barco("Buque", posiciones));
        }

        // Insertar los acorazados de 4x4 horizontal
        for (int i = 0; i < acorazados; i++) {
            ArrayList<Posicion> posiciones = new ArrayList<>();
            int posicionx, posiciony;
            do {
                posicionx = rand.nextInt(filas);
                posiciony = rand.nextInt(columnas - 3);  // Asegurarse de que haya espacio para el barco de 4x4
            } while (comprobarSolapamiento(posicionx, posiciony, 4, tableroOcupado));  // Verificar solapamiento

            for (int j = 0; j < 4; j++) {
                posiciones.add(new Posicion(posicionx, posiciony + j));
                tableroOcupado[posicionx][posiciony + j] = true;  // Marcar como ocupado
            }
            barcos.add(new Barco("Acorazado", posiciones));
        }

        // Insertar los portaaviones de 5x5 vertical
        for (int i = 0; i < portaaviones; i++) {
            ArrayList<Posicion> posiciones = new ArrayList<>();
            int posicionx, posiciony;
            do {
                posicionx = rand.nextInt(filas - 4);  // Asegurarse de que haya espacio para el barco de 5x5 vertical
                posiciony = rand.nextInt(columnas);
            } while (comprobarSolapamientoVertical(posicionx, posiciony, 5, tableroOcupado));  // Verificar solapamiento

            for (int j = 0; j < 5; j++) {
                posiciones.add(new Posicion(posicionx + j, posiciony));
                tableroOcupado[posicionx + j][posiciony] = true;  // Marcar como ocupado
            }
            barcos.add(new Barco("Portaaviones", posiciones));
        }

        return barcos;
    }

    // Verificar solapamiento horizontal
    public static boolean comprobarSolapamiento(int x, int y, int longitud, boolean[][] tableroOcupado) {
        for (int i = 0; i < longitud; i++) {
            if (tableroOcupado[x][y + i]) {
                return true;
            }
        }
        return false;
    }

    // Verificar solapamiento vertical
    public static boolean comprobarSolapamientoVertical(int x, int y, int longitud, boolean[][] tableroOcupado) {
        for (int i = 0; i < longitud; i++) {
            if (tableroOcupado[x + i][y]) {
                return true;
            }
        }
        return false;
    }

    // Método para convertir una letra de fila (A, B, C...) en un índice de fila (0, 1, 2...)
    public static int convertirFila(char fila) {
        return fila - 'A';  // Convierte la letra 'A' a 0, 'B' a 1, etc.
    }

    // Método para imprimir las posiciones de los barcos
    public static void imprimirPosiciones(ArrayList<Barco> barcos) {
        for (Barco barco : barcos) {
            System.out.print("Barco de tipo " + barco.getTipo() + " en posiciones: ");
            for (Posicion posicion : barco.getPosiciones()) {
                System.out.print("(" + (char)('A' + posicion.fila) + "," + (posicion.columna + 1) + ") ");
            }
            System.out.println();
        }
    }
}




