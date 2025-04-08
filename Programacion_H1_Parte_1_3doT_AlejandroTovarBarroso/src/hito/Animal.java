package hito;

public abstract class Animal {
	  String chip;
	    String nombre;
	    int edad;
	    String raza;
	    boolean adoptado;
	    public Animal(String chip, String nombre, int edad, String raza, boolean adoptado) {
	        this.chip = chip;
	        this.nombre = nombre;
	        this.edad = edad;
	        this.raza = raza;
	        this.adoptado = adoptado;
	    }
	    public abstract void mostrar();
	}
