package hito;
	public class Perro extends Animal {
		   String tamaño;
		   public Perro(String chip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
		       super(chip, nombre, edad, raza, adoptado);
		       this.tamaño = tamaño;
		   }
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
