package hito; 
public class Gato extends Animal {
	   boolean testLeucemia;
	   public Gato(String chip, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
	       super(chip, nombre, edad, raza, adoptado);
	       this.testLeucemia = testLeucemia;
	   }
	   public void mostrar() {
	       System.out.println("GATO:");
	       System.out.println("Chip: " + chip);
	       System.out.println("Nombre: " + nombre);
	       System.out.println("Edad: " + edad);
	       System.out.println("Raza: " + raza);
	       System.out.println("Adoptado: " + adoptado);
	       System.out.println("Test de leucemia: " + testLeucemia);
	   }
	}


