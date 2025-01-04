import java.util.ArrayList;
import java.util.Scanner;

public class Disparos {

    public static void seleccionarDisparo(ArrayList<Barcos.Posicion> posicionesLanchas, Tablero miTablero) {
        Scanner disparo = new Scanner(System.in);
    
        // Pedir la fila (letra) y asegurarse de que esté en el rango adecuado
        System.out.println("Selecciona la FILA (letra) para dirigir tu disparo (A, B, C...):");
        char filaDisparo = disparo.nextLine().toUpperCase().charAt(0);
        int filaDisparoIndex = Barcos.convertirFila(filaDisparo);
        
        if (filaDisparoIndex < 0 || filaDisparoIndex >= miTablero.getTablero().length) {
            System.out.println("Fila fuera del rango. Intenta de nuevo.");
            return;  // Salir del método si la fila no es válida
        }
    
        // Pedir la columna (número) y asegurarse de que esté dentro del rango adecuado
        System.out.println("Selecciona la COLUMNA para dirigir tu disparo (1, 2, 3...):");
        int columnaDisparo = disparo.nextInt() - 1;  // Convertir la columna para que sea 0-indexed
        
        if (columnaDisparo < 0 || columnaDisparo >= miTablero.getTablero()[0].length) {
            System.out.println("Columna fuera del rango. Intenta de nuevo.");
            return;  // Salir del método si la columna no es válida
        }
    
        // Comprobar si el disparo acierta o falla
        boolean acierto = comprobarDisparo(filaDisparoIndex, columnaDisparo, posicionesLanchas);
    
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
    }

    // Método para comprobar si el disparo es un acierto
    public static boolean comprobarDisparo(int fila, int columna, ArrayList<Barcos.Posicion> posicionesLanchas) {
        for (Barcos.Posicion pos : posicionesLanchas) {
            if (pos.fila == fila && pos.columna == columna) {
                return true;  // Acierto
            }
        }
        return false;  // Fallo
    }

    // Método que ejecuta las rondas de disparos
    public static void realizarDisparos(int rondas, ArrayList<Barcos.Posicion> posicionesLanchas, Tablero miTablero) {
        for (int i = 0; i < rondas; i++) {
            seleccionarDisparo(posicionesLanchas, miTablero);
        }
    }
}



// import java.util.ArrayList;
// import java.util.Scanner;

// public class Disparos {

   
//     int fila = 0;
//     int columna = 0;

//     public void seleccionarDisparo(){
//         Scanner disparo = new Scanner(System.in);

//         System.out.println("Selecciona la FILA para dirigir tu disparo");
//         int fila = disparo.nextInt();

//         disparo.nextLine();

//         System.out.println("Selecciona la COLUMNA para dirigir tu disparo");
//         int columna = disparo.nextInt();
//         disparo.close();
//     }


//     public boolean comprobarDisparo(int fila, int columna, ArrayList<int[][]> barcos) {

//         for (int i = 0; i < barcos.size(); i++) {

//             int[][] barco = barcos.get(i); 
    
           
//             if (barco[0][0] == fila && barco[0][1] == columna) {
//                 return true; // Acierto
//             }
//         }
//         return false; // Fallo
//     }
    
    
//     }

