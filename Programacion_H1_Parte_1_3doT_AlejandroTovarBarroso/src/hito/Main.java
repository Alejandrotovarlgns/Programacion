package hito;
	import java.util.ArrayList;
	import java.util.Scanner;
	public class Main {
	   public static void main(String[] args) {
	       ArrayList<Animal> listaAnimales = new ArrayList<>();
	       Scanner scanner = new Scanner(System.in);
	       boolean continuar = true;
	       while (continuar) {
	           System.out.println("¿Qué tipo de animal deseas crear?");
	           System.out.println("1. Perro");
	           System.out.println("2. Gato");
	           System.out.println("3. Ver lista de animales");
	           System.out.println("4. Salir");
	           System.out.print("Elige una opción (1-4): ");
	           int opcion = scanner.nextInt();
	           scanner.nextLine(); 
	           switch (opcion) {
	               case 1:
	                 
	                   Perro perro = crearPerro(scanner);
	                   listaAnimales.add(perro);
	                   break;
	               case 2:
	                   Gato gato = crearGato(scanner);
	                   listaAnimales.add(gato);
	                   break;
	               case 3:
	                   mostrarAnimales(listaAnimales);
	                   break;
	               case 4:
	                   continuar = false;
	                   break;
	               default:
	                   System.out.println("Opción no válida, por favor elige entre 1 y 4.");
	           }
	       }
	       scanner.close();
	   }
	   public static Perro crearPerro(Scanner scanner) {
	       System.out.println("Creando un perro");
	       System.out.print("Ingrese el chip del perro: ");
	       String chip = scanner.nextLine();
	      
	       System.out.print("Ingrese el nombre del perro: ");
	       String nombre = scanner.nextLine();
	      
	       System.out.print("Ingrese la edad del perro: ");
	       int edad = scanner.nextInt();
	      
	       scanner.nextLine(); 
	      
	       System.out.print("Ingrese la raza del perro: ");
	       String raza = scanner.nextLine();
	      
	       System.out.print("¿Está adoptado ? (true/false): ");
	       boolean adoptado = scanner.nextBoolean();
	      
	       scanner.nextLine(); 
	      
	       System.out.print("Ingrese el tamaño (pequeño, mediano, grande): ");
	       String tamaño = scanner.nextLine();
	      
	       return new Perro(chip, nombre, edad, raza, adoptado, tamaño);
	   }
	   public static Gato crearGato(Scanner scanner) {
	       System.out.println("Creando un gato");
	       System.out.print("Ingrese el chip del gato: ");
	       String chip = scanner.nextLine();
	      
	       System.out.print("Ingrese el nombre del gato: ");
	       String nombre = scanner.nextLine();
	      
	       System.out.print("Ingrese la edad del gato: ");
	       int edad = scanner.nextInt();
	      
	       scanner.nextLine(); 
	      
	       System.out.print("Ingrese la raza del gato: ");
	       String raza = scanner.nextLine();
	      
	       System.out.print("¿Está adoptado ? (true/false): ");
	       boolean adoptado = scanner.nextBoolean();
	      
	      
	       System.out.print("¿Tiene test de leucemia ? (true/false): ");
	       boolean testLeucemia = scanner.nextBoolean();
	      
	       return new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);
	   }
	   public static void mostrarAnimales(ArrayList<Animal> listaAnimales) {
	       if (listaAnimales.isEmpty()) {
	           System.out.println("No hay animales registrados.");
	       } else {
	           System.out.println("Lista de animales registrados:");
	           for (Animal animal : listaAnimales) {
	               animal.mostrar();
	               System.out.println();
	           }
	       }
	   }
	}
