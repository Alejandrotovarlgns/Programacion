// Indicamos que este archivo forma parte del paquete 'cine'
package cine;

// Importamos la clase Scanner para leer la entrada del usuario desde la consola
import java.util.Scanner;

public class Main {

    // Método principal, el que se ejecuta al iniciar la aplicación
    public static void main(String[] args) {
        
        // Usamos try-with-resources para asegurar que el Scanner se cierre automáticamente
        try (Scanner sc = new Scanner(System.in)) {
            
            // Declaramos una variable llamada 'opcion' que almacenará la elección del usuario
            int opcion;

            // Bucle do-while: se repite mientras el usuario no elija la opción 2 (Salir)
            do {
                // Mostramos un menú de opciones
                System.out.println("====== CINE ======");
                System.out.println("1 – Ver películas");   // Opción 1: Ver las películas disponibles
                System.out.println("2 – Salir");             // Opción 2: Salir del programa
                System.out.print("Elige una opción: ");      // Pedimos al usuario que elija una opción

                // Leemos la opción del usuario como un número entero
                opcion = sc.nextInt();

                // Estructura de control 'switch' para manejar las distintas opciones
                switch (opcion) {
                    // Si la opción es 1, mostramos las películas
                    case 1:
                        // Llamamos a PeliculaDAO para obtener todas las películas y las mostramos
                        for (Pelicula p : PeliculaDAO.obtenerPeliculas()) {
                            System.out.println(p);                   // Mostramos la información de cada película
                            System.out.println("----------------------------"); // Separador entre películas
                        }
                        break;

                    // Si la opción es 2, mostramos un mensaje de despedida
                    case 2:
                        System.out.println("¡Hasta luego!");    // Mensaje de despedida cuando se sale
                        break;

                    // Si el usuario elige una opción no válida, mostramos un mensaje de error
                    default:
                        System.out.println("Opción no válida."); // Mensaje de error si la opción no es 1 ni 2
                }
            } while (opcion != 2); // El bucle continuará hasta que el usuario elija la opción 2 (Salir)
        }
    }
}
