import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario si desea un modo personalizado
        System.out.println("¿Quieres un modo de juego personalizado? (S/N)");
        char respuesta = scanner.next().charAt(0);
        int lanchas, buques, acorazados, portaaviones, maxDisparos;

        if (respuesta == 'S' || respuesta == 's') {
            // Modo personalizado: Solicitar al usuario la cantidad de barcos y disparos
            System.out.print("Ingrese el número de lanchas: ");
            lanchas = scanner.nextInt();
            System.out.print("Ingrese el número de buques: ");
            buques = scanner.nextInt();
            System.out.print("Ingrese el número de acorazados: ");
            acorazados = scanner.nextInt();
            System.out.print("Ingrese el número de portaaviones: ");
            portaaviones = scanner.nextInt();
            System.out.print("Ingrese el número máximo de disparos: ");
            maxDisparos = scanner.nextInt();
        } else {
            // Pedir al usuario el nivel de dificultad
            System.out.println("Selecciona el nivel de dificultad:");
            System.out.println("1. Fácil");
            System.out.println("2. Medio");
            System.out.println("3. Difícil");
            System.out.print("Ingresa el número del nivel de dificultad (1, 2, 3): ");
            int dificultad = scanner.nextInt();

            // Definir los parámetros del juego según la dificultad seleccionada
            if (dificultad == 1) {  // Fácil
                lanchas = 5;
                buques = 3;
                acorazados = 1;
                portaaviones = 1;
                maxDisparos = 50;  // Número máximo de disparos para el nivel fácil
            } else if (dificultad == 2) {  // Medio
                lanchas = 2;
                buques = 1;
                acorazados = 1;
                portaaviones = 1;
                maxDisparos = 30;  // Número máximo de disparos para el nivel medio
            } else if (dificultad == 3) {  // Difícil
                lanchas = 1;
                buques = 1;
                acorazados = 0;
                portaaviones = 0;
                maxDisparos = 10;  // Número máximo de disparos para el nivel difícil
            } else {
                System.out.println("Opción no válida. Se ha seleccionado el nivel Medio por defecto.");
                lanchas = 2;
                buques = 1;
                acorazados = 1;
                portaaviones = 1;
                maxDisparos = 30;  // Número máximo de disparos para el nivel medio por defecto
            }
        }

        // Crear el tablero de 10x10
        Tablero tablero = new Tablero(10, 10);

        // Insertar los barcos según el número elegido
        ArrayList<Barcos.Barco> barcos = Barcos.insertarBarcos(10, 10, lanchas, buques, acorazados, portaaviones);

        // Establecer el número máximo de disparos según el nivel o el modo personalizado
        Disparos.establecerMaxDisparos(maxDisparos);

        // Imprimir el tablero antes de disparar
        tablero.imprimirTablero();

        // Iniciar el juego con disparos
        int disparosRealizados = 0;
        while (disparosRealizados <= maxDisparos) {
            // Seleccionar y hacer disparos
            boolean juegoTerminado = Disparos.seleccionarDisparo(barcos, tablero);
            disparosRealizados++;

            // Verificar si todos los barcos han sido hundidos
            boolean todosHundidos = true;
            for (Barcos.Barco barco : barcos) {
                for (Barcos.Posicion posicion : barco.getPosiciones()) {
                    if (tablero.getTablero()[posicion.fila][posicion.columna].equals("-")) {
                        todosHundidos = false;
                        break;
                    }
                }
                if (!todosHundidos) break;
            }

            // Si todos los barcos han sido hundidos, terminar el juego
            if (todosHundidos) {
                System.out.println("¡Felicidades! Has hundido todos los barcos.");
                break;
            }

            // Terminar el juego si se han agotado los disparos
            if (juegoTerminado) {
                System.out.println("Se acabaron los disparos. Fin del juego.");
                break;
            }
        }

        // Mostrar el tablero con las posiciones de los barcos al final del juego
        System.out.println("Posiciones de los barcos:");
        tablero.mostrarPosicionesBarcos(barcos);
        tablero.imprimirTablero();

        scanner.close();
    }
}