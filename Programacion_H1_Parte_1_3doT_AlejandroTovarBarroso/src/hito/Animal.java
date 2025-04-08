package hito;

public abstract class Animal {
	 // Datos que tienen todos los animales: chip, nombre, edad, raza y si está adoptado
	  String chip;
	    String nombre;
	    int edad;
	    String raza;
	    boolean adoptado;
	 // Constructor: sirve para crear un animal con todos sus datos
	    public Animal(String chip, String nombre, int edad, String raza, boolean adoptado) {
	        this.chip = chip;
	        this.nombre = nombre;
	        this.edad = edad;
	        this.raza = raza;
	        this.adoptado = adoptado;
	    }
	    // Método obligatorio que tendrán que hacer las clases hijas (como Perro o Gato)
	    public abstract void mostrar();
	}
