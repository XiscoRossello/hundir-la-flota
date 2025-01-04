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

    // Método para insertar barcos en el tablero y devolver sus posiciones
    public static ArrayList<Posicion> insertarBarcos(int filas, int columnas, int lanchas) {
        ArrayList<Posicion> posicionesLanchas = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < lanchas; i++) {
            int posicionx, posiciony;

            // Asegurarse de que los barcos no se solapen
            do {
                posicionx = rand.nextInt(filas);  // Genera una fila dentro del rango
                posiciony = rand.nextInt(columnas);  // Genera una columna dentro del rango
            } while (yaEstaOcupado(posicionx, posiciony, posicionesLanchas));

            // Añadir la nueva posición del barco a la lista
            posicionesLanchas.add(new Posicion(posicionx, posiciony));
            // System.out.println("Barco colocado en Fila: " + (char)('A' + posicionx) + ", Columna: " + (posiciony + 1));
        }
        return posicionesLanchas;
    }

    // Método para comprobar si una posición ya está ocupada por otro barco
    public static boolean yaEstaOcupado(int posicionx, int posiciony, ArrayList<Posicion> posicionesLanchas) {
        for (Posicion pos : posicionesLanchas) {
            if (pos.fila == posicionx && pos.columna == posiciony) {
                return true;
            }
        }
        return false;
    }

    // Método para convertir una letra de fila (A, B, C...) en un índice de fila (0, 1, 2...)
    public static int convertirFila(char fila) {
        return fila - 'A';  // Convierte la letra 'A' a 0, 'B' a 1, etc.
    }
}


// import java.util.Random;
// import java.util.ArrayList;

// public class Barcos {
//     public static void insertarBarcos(int filas, int columnas, int lanchas) {
//         ArrayList<int[][]> posicionesLanchas = new ArrayList<>();

//         Random rand = new Random();

//         for (int i = 0; i < lanchas; i++) {
//             int posicionx, posiciony;

//             do {
//                 posicionx = rand.nextInt(filas+1);  
//                 posiciony = rand.nextInt(columnas+1); 
//             } while (posicionx == 0 || posiciony == 0 || yaEstaOcupado(posicionx, posiciony, posicionesLanchas));

//             // Se almacena la posición del barco en el array bidimensional 1x2
//             posicionesLanchas.add(new int[][] {{posicionx, posiciony}});
//             System.out.println("Barco colocado en Fila: " + posicionx + ", Columna: " + posiciony);
//         }
//     }

//     public static boolean yaEstaOcupado(int posicionx, int posiciony, ArrayList<int[][]> posicionesLanchas) {
//         for (int i = 0; i < posicionesLanchas.size(); i++) {
//             int[][] pos = posicionesLanchas.get(i);
            
//             // Comprobamos si la posición ya está ocupada
//             if (pos[0][0] == posicionx && pos[0][1] == posiciony) {
//                 return true;
//             }
          
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         insertarBarcos(10, 10, 5);  // Llamada para colocar 5 barcos en un mapa de 10x10
//     }
// }
