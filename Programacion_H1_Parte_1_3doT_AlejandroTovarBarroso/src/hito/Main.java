package hito;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Animal> animales = new HashMap<>();
    static ArrayList<Adopcion> adopciones = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        // Bucle principal que muestra el menú y ejecuta la opción elegida por el usuario
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> darAlta(); // Opción para dar de alta un nuevo animal
                    case 2 -> listarAnimales(); // Opción para listar todos los animales
                    case 3 -> buscarAnimal(); // Opción para buscar un animal por chip
                    case 4 -> realizarAdopcion(); // Opción para registrar una adopción
                    case 5 -> darBaja(); // Opción para eliminar un animal
                    case 6 -> estadisticasGatos(); // Opción para mostrar estadísticas de gatos
                    case 7 -> System.out.println("Saliendo..."); // Salida del programa
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
                opcion = 0;
            }
        } while (opcion != 7);
    }

    // Muestra el menú principal con todas las opciones disponibles
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1 – Dar de alta animal");
        System.out.println("2 – Listar animales");
        System.out.println("3 – Buscar animal");
        System.out.println("4 – Realizar adopción");
        System.out.println("5 – Dar de baja");
        System.out.println("6 – Mostrar estadísticas de gatos");
        System.out.println("7 – Salir");
        System.out.print("Elige una opción: ");
    }

    // Permite al usuario registrar un nuevo animal (perro o gato)
    public static void darAlta() {
        System.out.print("¿Qué tipo de animal es (perro/gato)? ");
        String tipo = sc.nextLine().toLowerCase();

        System.out.print("Chip: ");
        String chip = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        if (tipo.equals("perro")) {
            System.out.print("Raza: ");
            String raza = sc.nextLine();
            animales.put(chip, new Perro(chip, nombre, edad, raza));
        } else if (tipo.equals("gato")) {
            System.out.print("¿Test de leucemia positivo? (true/false): ");
            boolean leucemia = Boolean.parseBoolean(sc.nextLine());
            animales.put(chip, new Gato(chip, nombre, edad, leucemia));
        } else {
            System.out.println("Tipo no reconocido.");
        }
    }

    // Muestra la lista de todos los animales registrados
    public static void listarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            animales.values().forEach(System.out::println);
        }
    }

    // Busca y muestra los datos de un animal a partir de su número de chip
    public static void buscarAnimal() {
        System.out.print("Introduce el chip del animal: ");
        String chip = sc.nextLine();
        Animal animal = animales.get(chip);
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    // Registra una adopción si el animal existe y no ha sido adoptado aún
    public static void realizarAdopcion() {
        System.out.print("Introduce el chip del animal: ");
        String chip = sc.nextLine();
        Animal animal = animales.get(chip);

        if (animal == null) {
            System.out.println("Animal no encontrado.");
        } else if (animal.isAdoptado()) {
            System.out.println("El animal ya ha sido adoptado.");
        } else {
            System.out.print("Nombre de la persona: ");
            String nombre = sc.nextLine();
            System.out.print("DNI: ");
            String dni = sc.nextLine();
            animal.setAdoptado(true);
            adopciones.add(new Adopcion(animal, nombre, dni));
            System.out.println("Adopción realizada con éxito.");
        }
    }

    // Elimina un animal del sistema, y si está adoptado, también elimina la adopción
    public static void darBaja() {
        System.out.print("Introduce el chip del animal: ");
        String chip = sc.nextLine();
        Animal animal = animales.remove(chip);

        if (animal == null) {
            System.out.println("Animal no encontrado.");
        } else {
            adopciones.removeIf(adopcion -> adopcion.getAnimal().getChip().equals(chip));
            System.out.println("Animal eliminado correctamente.");
        }
    }

    // Muestra estadísticas de gatos: total registrados y cuántos tienen leucemia
    public static void estadisticasGatos() {
        long total = animales.values().stream().filter(a -> a instanceof Gato).count();
        long conLeucemia = animales.values().stream()
            .filter(a -> a instanceof Gato && ((Gato) a).isTestLeucemia())
            .count();

        System.out.println("Total de gatos: " + total);
        System.out.println("Gatos con leucemia: " + conLeucemia);
    }
}
