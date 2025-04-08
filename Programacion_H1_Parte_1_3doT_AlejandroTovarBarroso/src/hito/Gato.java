package hito; 
public class Gato extends Animal {
	//para q solo los gatos tengan el test de leucemia
	   boolean testLeucemia;
	   //constructor para crear un objeto Gato, asignando los datos del Animal y el test de leucemia
	   public Gato(String chip, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
	       super(chip, nombre, edad, raza, adoptado);
	       this.testLeucemia = testLeucemia;
	   }
	   // Método mostrar: muestra toda la información del gato, incluyendo si pasó el test de leucemia
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


