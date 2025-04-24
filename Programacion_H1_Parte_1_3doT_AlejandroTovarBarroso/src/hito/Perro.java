package hito;

// Clase Perro que hereda de la clase Animal
public class Perro extends Animal {
    private String raza; // Atributo específico para perros: raza

    // Constructor de Perro que recibe chip, nombre, edad y raza
    public Perro(String chip, String nombre, int edad, String raza) {
        super(chip, nombre, edad); // Llama al constructor de la clase padre (Animal)
        this.raza = raza;
    }

    // Getter para obtener la raza del perro
    public String getRaza() {
        return raza;
    }

    // Método que devuelve el tipo del animal, en este caso "Perro"
    @Override
    public String getTipo() {
        return "Perro";
    }

    // Método para representar el perro como cadena de texto, incluyendo la raza
    @Override
    public String toString() {
        return super.toString() + " | Raza: " + raza;
    }
}
