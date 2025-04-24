package hito;

// Clase Gato que hereda de la clase abstracta Animal
public class Gato extends Animal {
    // Atributo específico de los gatos: resultado del test de leucemia
    private boolean testLeucemia;

    // Constructor que inicializa los datos del gato, incluyendo el test de leucemia
    public Gato(String chip, String nombre, int edad, boolean testLeucemia) {
        super(chip, nombre, edad); // Llama al constructor de la clase padre Animal
        this.testLeucemia = testLeucemia;
    }

    // Getter para obtener el resultado del test de leucemia
    public boolean isTestLeucemia() {
        return testLeucemia;
    }

    // Implementación del método abstracto de Animal para indicar que es un Gato
    @Override
    public String getTipo() {
        return "Gato";
    }

    // Método toString que añade información del test de leucemia al texto general del animal
    @Override
    public String toString() {
        return super.toString() + " | Test leucemia: " + testLeucemia;
    }
}
