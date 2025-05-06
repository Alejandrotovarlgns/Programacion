// Indicamos que este archivo forma parte del paquete 'cine'
package cine;

import java.sql.*;         // Importamos clases necesarias para trabajar con bases de datos SQL
import java.util.ArrayList; // Importamos la clase ArrayList para almacenar las películas obtenidas

public class PeliculaDAO {

    // Método estático que devuelve una lista de películas obtenidas desde la base de datos
    public static ArrayList<Pelicula> obtenerPeliculas() {
        
        // Creamos una lista vacía de películas
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        // Consulta SQL para obtener las películas y la información de la sala asociada
        String query = "SELECT p.*, s.nombre, s.capacidad FROM peliculas p " +
                       "JOIN salas s ON p.id_sala = s.id";  // Unimos las tablas 'peliculas' y 'salas'

        // Usamos try-with-resources para asegurar que la conexión, declaración y resultado se cierren correctamente
        try (Connection conn = Conexion.getConnection();  // Establecemos la conexión con la base de datos
             Statement stmt = conn.createStatement();       // Creamos un Statement para ejecutar la consulta SQL
             ResultSet rs = stmt.executeQuery(query)) {     // Ejecutamos la consulta y obtenemos los resultados

            // Mientras haya registros en el ResultSet, procesamos cada película
            while (rs.next()) {
                // Creamos un objeto Sala con los datos obtenidos de la base de datos
                Sala sala = new Sala(rs.getInt("id_sala"),      // Obtenemos el id de la sala
                                     rs.getString("nombre"),   // Obtenemos el nombre de la sala
                                     rs.getInt("capacidad"));  // Obtenemos la capacidad de la sala

                // Creamos un objeto Pelicula con los datos obtenidos de la base de datos
                Pelicula peli = new Pelicula(
                        rs.getInt("id"),            // Obtenemos el id de la película
                        rs.getString("titulo"),     // Obtenemos el título de la película
                        rs.getInt("duracion"),      // Obtenemos la duración de la película
                        rs.getString("genero"),     // Obtenemos el género de la película
                        rs.getString("idioma"),     // Obtenemos el idioma de la película
                        sala                        // Asignamos el objeto Sala que acabamos de crear
                );

                // Añadimos la película a la lista
                peliculas.add(peli);
            }

        } catch (SQLException e) {
            // Si ocurre un error en la conexión o consulta, se imprime un mensaje de error
            System.out.println("Error al obtener películas: " + e.getMessage());
        }

        // Devolvemos la lista de películas
        return peliculas;
    }
}
