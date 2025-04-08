package hito;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Lista global donde guardamos todos los animales registrados
    public static ArrayList<Animal> listaAnimales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // El menú se repite hasta que el usuario decida salir
        while (!salir) {
            System.out.println("---Menú principal---");
            System.out.println("1. Añadir un perro");
            System.out.println("2. Añadir un gato");
            System.out.println("3. Buscar animal por chip");
            System.out.println("4. Ver todos los animales");
            System.out.println("5. Salir del sistema");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarPerro(scanner); // Añade un nuevo perro
                case 2 -> registrarGato(scanner);  // Añade un nuevo gato
                case 3 -> buscarPorChip(scanner);  // Busca animal por chip
                case 4 -> mostrarTodos();          // Muestra la lista completa
                case 5 -> {
                    salir = true;
                    System.out.println("Gracias por usar el sistema.");
                }
                default -> System.out.println("Opción incorrecta. Intenta de nuevo.");
            }
        }

        scanner.close(); // Cerramos el escáner cuando ya no se usará
    }

    // Registra un perro con los datos introducidos por el usuario
    public static void registrarPerro(Scanner scanner) {
        System.out.println("Registro de perro:");
        String chip = pedirChip(scanner);
        String nombre = pedirTexto(scanner, "Nombre");
        int edad = pedirEntero(scanner, "Edad");
        String raza = pedirTexto(scanner, "Raza");
        boolean adoptado = pedirBooleano(scanner, "¿Está adoptado? (true/false)");
        String tamaño = pedirTexto(scanner, "Tamaño (pequeño/mediano/grande)");

        Perro perro = new Perro(chip, nombre, edad, raza, adoptado, tamaño);
        listaAnimales.add(perro);
        System.out.println("¡Perro añadido con éxito!");
    }

    // Registra un gato con los datos introducidos por el usuario
    public static void registrarGato(Scanner scanner) {
        System.out.println("Registro de gato:");
        String chip = pedirChip(scanner);
        String nombre = pedirTexto(scanner, "Nombre");
        int edad = pedirEntero(scanner, "Edad");
        String raza = pedirTexto(scanner, "Raza");
        boolean adoptado = pedirBooleano(scanner, "¿Está adoptado? (true/false)");
        boolean leucemia = pedirBooleano(scanner, "¿Test de leucemia positivo? (true/false)");

        Gato gato = new Gato(chip, nombre, edad, raza, adoptado, leucemia);
        listaAnimales.add(gato);
        System.out.println("¡Gato añadido con éxito!");
    }

    // Permite buscar un animal usando su número de chip
    public static void buscarPorChip(Scanner scanner) {
        String chip = pedirTexto(scanner, "Introduce el número de chip");
        boolean encontrado = false;

        for (Animal animal : listaAnimales) {
            if (animal.chip.equals(chip)) {
                animal.mostrar(); // Mostramos al animal encontrado
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado ningún animal con ese chip.");
        }
    }
// Muestra todos los animales registrados en la lista
    public static void mostrarTodos() {
        if (listaAnimales.isEmpty()) {
            System.out.println("Aún no hay animales registrados.");
        } else {
            System.out.println("=== Lista de animales ===");
            for (Animal a : listaAnimales) {
                a.mostrar();
            }
        }
    }

    // Solicita un texto al usuario
    public static String pedirTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    // Solicita un número entero al usuario
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Solicita un valor booleano al usuario (true/false)
    public static boolean pedirBooleano(Scanner scanner, String mensaje) {
        System.out.print(mensaje + ": ");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    // Pide un número de chip único (no repetido)
    public static String pedirChip(Scanner scanner) {
        while (true) {
            String chip = pedirTexto(scanner, "Número de chip");
            boolean repetido = false;

            for (Animal a : listaAnimales) {
                if (a.chip.equals(chip)) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) return chip;

            System.out.println("Ese chip ya está registrado. Intenta con otro.");
        }
    }
}
