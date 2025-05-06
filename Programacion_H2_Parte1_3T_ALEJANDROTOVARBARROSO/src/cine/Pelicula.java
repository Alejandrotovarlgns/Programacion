// Indicamos que este archivo forma parte del paquete 'cine'
package cine;

public class Pelicula {
    
    // Atributos de la clase Pelicula: 
    // Definimos las propiedades de cada película que vamos a crear en este objeto.
    private int id;            // Identificador único para cada película
    private String titulo;     // Título de la película
    private int duracion;      // Duración de la película en minutos
    private String genero;     // Género de la película (por ejemplo, acción, comedia, etc.)
    private String idioma;     // Idioma en el que se proyecta la película
    private Sala sala;         // Objeto de tipo Sala que indica en qué sala se proyecta la película

    // Constructor de la clase Pelicula que inicializa los atributos de la película
    public Pelicula(int id, String titulo, int duracion, String genero, String idioma, Sala sala) {
        this.id = id;             // Inicializa el id con el valor pasado como parámetro
        this.titulo = titulo;     // Inicializa el título con el valor pasado como parámetro
        this.duracion = duracion; // Inicializa la duración con el valor pasado como parámetro
        this.genero = genero;     // Inicializa el género con el valor pasado como parámetro
        this.idioma = idioma;     // Inicializa el idioma con el valor pasado como parámetro
        this.sala = sala;         // Inicializa la sala con el valor pasado como parámetro
    }

    // Sobrescribimos el método toString para mostrar la información de la película de manera más amigable
    @Override
    public String toString() {
        // Usamos String.format para formatear la salida con los datos de la película
        return String.format("Película: %s (%d min)\nGénero: %s | Idioma: %s\n%s\n", 
                              titulo, duracion, genero, idioma, sala); // Devuelve un resumen de la película
    }
}
