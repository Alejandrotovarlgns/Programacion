// Indicamos que este archivo pertenece al paquete 'cine'
package cine;

import java.sql.*;
import java.util.Scanner;

/**
 * Clase que contiene la lógica para gestionar las películas en la base de datos.
 */
public class PeliculaDAO {

    // Variables de usuario y contraseña (no se usan en este archivo, ya que se conecta mediante Conexion.conectar())
    String usuario = "root";
    String contraseña = "root123";

    // Scanner global y estático para reutilizarlo en los métodos de entrada por teclado
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Método que muestra por pantalla todas las películas almacenadas en la base de datos.
     */
    public static void verPeliculas() {
        // Intenta establecer conexión con la base de datos
        try (Connection con = Conexion.conectar()) {
            // Consulta SQL para obtener todas las películas
            String sql = "SELECT * FROM peliculas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("Películas disponibles:");
            // Recorre el resultado y crea objetos Pelicula para mostrarlos
            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getString("genero"),
                        rs.getInt("anio")
                );
                System.out.println(p);
            }
        } catch (SQLException e) {
            // Captura e imprime errores relacionados con la base de datos
            System.err.println("Error al mostrar películas: " + e.getMessage());
        }
    }

    /**
     * Método que permite añadir una nueva película a la base de datos.
     */
    public static void anadirPelicula() {
        try (Connection con = Conexion.conectar()) {
            // Solicita el ID y verifica que no exista previamente en la base de datos
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            String consulta = "SELECT * FROM peliculas WHERE id = ?";
            PreparedStatement check = con.prepareStatement(consulta);
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                // Si ya hay una película con ese ID, se cancela la operación
                System.out.println("Ya existe una película con ese ID.");
                return;
            }

            // Solicita los demás datos de la nueva película
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Director: ");
            String director = sc.nextLine();
            System.out.print("Género: ");
            String genero = sc.nextLine();
            System.out.print("Año: ");
            int anio = Integer.parseInt(sc.nextLine());

            // Inserta la nueva película en la base de datos
            String sql = "INSERT INTO peliculas VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, titulo);
            ps.setString(3, director);
            ps.setString(4, genero);
            ps.setInt(5, anio);

            ps.executeUpdate(); // Ejecuta la inserción
            System.out.println("Película añadida correctamente.");
        } catch (SQLException | NumberFormatException e) {
            // Captura errores de SQL o de conversión numérica
            System.err.println("Error al añadir película: " + e.getMessage());
        }
    }

    /**
     * Método que elimina una película de la base de datos según su ID.
     */
    public static void eliminarPelicula() {
        try (Connection con = Conexion.conectar()) {
            // Solicita al usuario el ID de la película a eliminar
            System.out.print("ID de la película a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            // Prepara la consulta SQL para eliminar la película
            String sql = "DELETE FROM peliculas WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int filas = ps.executeUpdate(); // Ejecuta la eliminación
            if (filas > 0) {
                System.out.println("Película eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con ese ID.");
            }
        } catch (SQLException | NumberFormatException e) {
            System.err.println("Error al eliminar película: " + e.getMessage());
        }
    }

    /**
     * Método que permite modificar los datos de una película existente.
     */
    public static void modificarPelicula() {
        try (Connection con = Conexion.conectar()) {
            // Solicita el ID de la película a modificar
            System.out.print("ID de la película a modificar: ");
            int id = Integer.parseInt(sc.nextLine());

            // Verifica si existe una película con ese ID
            String consulta = "SELECT * FROM peliculas WHERE id = ?";
            PreparedStatement check = con.prepareStatement(consulta);
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("No se encontró ninguna película con ese ID.");
                return;
            }

            // Solicita los nuevos datos (sólo título y director, según este código)
            System.out.print("Nuevo título: ");
            String titulo = sc.nextLine();
            System.out.print("Nuevo director: ");
            String director = sc.nextLine();

            // Actualiza la información en la base de datos
            String sql = "UPDATE peliculas SET titulo = ?, director = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, director);
            ps.setInt(3, id);

            ps.executeUpdate(); // Ejecuta la actualización
            System.out.println("Película modificada correctamente.");
        } catch (SQLException | NumberFormatException e) {
            System.err.println("Error al modificar película: " + e.getMessage());
        }
    }
}
