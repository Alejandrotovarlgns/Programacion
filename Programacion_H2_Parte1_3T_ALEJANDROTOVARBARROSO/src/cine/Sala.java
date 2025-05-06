// Indicamos que este archivo forma parte del paquete 'cine'
package cine;

public class Sala {

    // Atributos de la clase Sala: Definen las propiedades de una sala de cine.
    private int id;            // Identificador único de la sala
    private String nombre;     // Nombre de la sala
    private int capacidad;     // Capacidad de la sala (número de personas que puede albergar)

    // Constructor de la clase Sala que inicializa los atributos con los valores proporcionados
    public Sala(int id, String nombre, int capacidad) {
        this.id = id;            // Inicializa el id de la sala
        this.nombre = nombre;    // Inicializa el nombre de la sala
        this.capacidad = capacidad; // Inicializa la capacidad de la sala
    }

    // Métodos getter para acceder a los valores de los atributos

    public int getId() {
        return id; // Devuelve el id de la sala
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre de la sala
    }

    public int getCapacidad() {
        return capacidad; // Devuelve la capacidad de la sala
    }

    // Sobrescribimos el método toString para mostrar la información de la sala de manera más amigable
    @Override
    public String toString() {
        // Devuelve una representación en formato de texto de la sala
        return "Sala " + nombre + " (Capacidad: " + capacidad + ")";
    }
}
