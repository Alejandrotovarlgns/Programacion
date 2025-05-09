// Indicamos que este archivo forma parte del paquete llamado 'cine'
package cine;

// Importamos la clase Scanner para poder leer datos introducidos por el usuario por consola
import java.util.Scanner;

/**
 * Clase principal que muestra el menú y gestiona las opciones del usuario.
 */
public class Main {

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer entradas del usuario
        Scanner sc = new Scanner(System.in);
        
        // Variable para almacenar la opción elegida por el usuario
        int opcion;

        // Bucle que se repite hasta que el usuario elige la opción 5 (Salir)
        do {
            // Mostramos el menú de opciones
            System.out.println("\n--- GESTIÓN DE CINE ---");
            System.out.println("1 – Ver Películas");
            System.out.println("2 – Añadir Película");
            System.out.println("3 – Eliminar Película");
            System.out.println("4 – Modificar Película");
            System.out.println("5 – Salir");
            System.out.print("Elige una opción: ");

            try {
                // Leemos la opción introducida por el usuario y la convertimos a entero
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                // Si el usuario introduce algo que no sea un número, mostramos un mensaje de error
                System.out.println("Por favor, introduce un número válido.");
                // Asignamos 0 a 'opcion' para que se vuelva a mostrar el menú
                opcion = 0;
            }

            // Usamos un switch para ejecutar la acción correspondiente según la opción elegida
            switch (opcion) {
                case 1 -> PeliculaDAO.verPeliculas();          // Llama al método para ver películas
                case 2 -> PeliculaDAO.anadirPelicula();        // Llama al método para añadir una película
                case 3 -> PeliculaDAO.eliminarPelicula();      // Llama al método para eliminar una película
                case 4 -> PeliculaDAO.modificarPelicula();     // Llama al método para modificar una película
                case 5 -> System.out.println("¡Hasta pronto!"); // Mensaje de despedida al salir
                default -> System.out.println("Opción no válida."); // Mensaje si la opción no es válida
            }
        } while (opcion != 5); // El bucle continúa hasta que el usuario elige salir (opción 5)

        // Cerramos el objeto Scanner al finalizar
        sc.close();
    }
}
