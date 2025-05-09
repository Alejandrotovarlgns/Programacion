// Indicamos que este archivo pertenece al paquete 'cine'
package cine;

/**
 * Clase que representa una película.
 * Contiene atributos como id, título, director, género y año,
 * junto con sus respectivos métodos para acceder y modificar estos datos.
 */
public class Pelicula {
    // Atributo que almacena el identificador único de la película
    private int id;
    
    // Atributo que almacena el título de la película
    private String titulo;
    
    // Atributo que almacena el nombre del director de la película
    private String director;
    
    // Atributo que almacena el género de la película (acción, comedia, etc.)
    private String genero;
    
    // Atributo que almacena el año de estreno de la película
    private int anio;

    // Constructor de la clase que permite inicializar todos los atributos al crear un objeto Pelicula
    public Pelicula(int id, String titulo, String director, String genero, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anio = anio;
    }

    // Método getter que devuelve el id de la película
    public int getId() {
        return id;
    }

    // Método getter que devuelve el título de la película
    public String getTitulo() {
        return titulo;
    }

    // Método getter que devuelve el nombre del director
    public String getDirector() {
        return director;
    }

    // Método getter que devuelve el género de la película
    public String getGenero() {
        return genero;
    }

    // Método getter que devuelve el año de la película
    public int getAnio() {
        return anio;
    }

    // Método setter que permite modificar el título de la película
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Método setter que permite modificar el director de la película
    public void setDirector(String director) {
        this.director = director;
    }

    // Método setter que permite modificar el género de la película
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Método setter que permite modificar el año de la película
    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Método sobrescrito que devuelve una representación en texto del objeto Pelicula
    @Override
    public String toString() {
        return id + " - " + titulo + " | Director: " + director + " | Género: " + genero + " | Año: " + anio;
    }
}
