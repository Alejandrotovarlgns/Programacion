package hito;

// Clase abstracta Animal, base para otras clases como Perro y Gato
public abstract class Animal {
    // Atributos comunes a todos los animales
    protected String chip;
    protected String nombre;
    protected int edad;
    protected boolean adoptado;

    // Constructor que inicializa los datos del animal
    public Animal(String chip, String nombre, int edad) {
        this.chip = chip;
        this.nombre = nombre;
        this.edad = edad;
        this.adoptado = false; // Por defecto, el animal no está adoptado
    }

    // Métodos getter para acceder a los atributos
    public String getChip() {
        return chip;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    // Método setter para cambiar el estado de adopción
    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    // Método abstracto que será implementado en las subclases para indicar el tipo de animal
    public abstract String getTipo();

    // Método toString que devuelve una representación en texto del animal
    @Override
    public String toString() {
        return "Tipo: " + getTipo() +
               " | Chip: " + chip +
               " | Nombre: " + nombre +
               " | Edad: " + edad +
               " | Adoptado: " + adoptado;
    }
}
