package hito;
	public class Perro extends Animal {
		// Atributo específico de Perro: tamaño, que indica el tamaño del perro (grande, mediano, pequeño)
		   String tamaño;
		   // Constructor: crea un Perro asignando los datos comunes de Animal + el tamaño del perro
		   public Perro(String chip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
		       super(chip, nombre, edad, raza, adoptado);
		       this.tamaño = tamaño;
		   }
		   // Método mostrar: muestra toda la información del perro, incluido su tamaño
		   public void mostrar() {
		       System.out.println("PERRO:");
		       System.out.println("Chip: " + chip);
		       System.out.println("Nombre: " + nombre);
		       System.out.println("Edad: " + edad);
		       System.out.println("Raza: " + raza);
		       System.out.println("Adoptado: " + adoptado);
		       System.out.println("Tamaño: " + tamaño);
		   }
		}
