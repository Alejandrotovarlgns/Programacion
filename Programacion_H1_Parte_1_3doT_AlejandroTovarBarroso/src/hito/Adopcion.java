package hito;

// Clase Adopcion que representa el registro de una adopción de un animal
public class Adopcion {
    // Atributo que almacena el animal adoptado
    private Animal animal;
    // Nombre de la persona que adopta al animal
    private String nombrePersona;
    // DNI de la persona que adopta
    private String dni;

    // Constructor que inicializa todos los atributos de la adopción
    public Adopcion(Animal animal, String nombrePersona, String dni) {
        this.animal = animal;
        this.nombrePersona = nombrePersona;
        this.dni = dni;
    }

    // Devuelve el animal adoptado
    public Animal getAnimal() {
        return animal;
    }

    // Devuelve el nombre de la persona que adoptó
    public String getNombrePersona() {
        return nombrePersona;
    }

    // Devuelve el DNI de la persona que adoptó
    public String getDni() {
        return dni;
    }

    // Método que devuelve un resumen en texto de la adopción
    @Override
    public String toString() {
        return "Adopción de " + animal.getNombre() + " por " + nombrePersona + " (DNI: " + dni + ")";
    }
}
