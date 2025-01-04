public class Tablero {
    private String[][] tablero;

    // Constructor para inicializar el tablero con el tamaño proporcionado
    public Tablero(int filas, int columnas) {
        tablero = new String[filas][columnas];
        // Inicializar el tablero con "-" como marcador por defecto
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = "-";
            }
        }
    }

    // Método para obtener el tablero
    public String[][] getTablero() {
        return tablero;
    }

    // Método para imprimir el tablero
    public void imprimirTablero() {
        System.out.print("  ");
        for (int i = 1; i <= tablero[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char)('A' + i) + " "); // Mostrar la letra de la fila
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para actualizar el tablero con "X" o "0"
    public void actualizarTablero(int fila, int columna, String marcador) {
        tablero[fila][columna] = marcador;
    }
}

//     public static void imprimirTablero(int filas, int columnas){
        
//         int[][] tablero = new int[filas+1][columnas+1]; 
//         char letra ='A';
//         int numero = 1;

//         for(int i = 0; i<tablero.length; i++){
//             for(int j = 0; j<tablero[i].length; j++){
//                 if (i == 0 && j == 0){
//                     System.out.print(" ");
//                 }
//                 else if (i == 0){
//                     System.out.print(numero + " ");
//                     numero++;
//                 }
//                 else if (j == 0){
//                     System.out.print(letra + " ");
//                     letra++;
//                 }
//                 else{ System.out.print("- ");}
               
//         }
//         System.out.println();
//     }
// }
