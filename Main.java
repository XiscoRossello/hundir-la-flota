import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inicializar el tablero de 10x10
        Tablero miTablero = new Tablero(10, 10);
        miTablero.imprimirTablero();

        // Insertar barcos en el tablero (5 barcos en un tablero de 10x10)
        ArrayList<Barcos.Posicion> posicionesLanchas = Barcos.insertarBarcos(10, 10, 10);

        // Realizar 10 rondas de disparos
        Disparos.realizarDisparos(50, posicionesLanchas, miTablero);
    }
}



    //     Tablero miTablero = new Tablero(10, 10);
    //     miTablero.imprimirTablero();
    //     Barcos.insertarBarcos(10, 10, 5);
    //     Disparos.seleccionarDisparo();

        
        
    // }
