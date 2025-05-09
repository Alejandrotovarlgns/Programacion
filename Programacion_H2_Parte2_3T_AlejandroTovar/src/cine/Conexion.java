// Indicamos que este archivo forma parte del paquete llamado 'cine'
package cine;

// Importamos las clases necesarias para la conexión a la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Declaramos la clase 'Conexion' que se encargará de gestionar la conexión a la base de datos
public class Conexion {

    // Método público y estático que se llama 'conectar' y devuelve un objeto de tipo Connection
    public static Connection conectar() {
        // Cadena de conexión a la base de datos MySQL, con el nombre de la base de datos 'cine_AlejandroTovar'
        String url = "jdbc:mysql://localhost:3306/cine_AlejandroTovar";
        
        // Nombre de usuario con el que nos conectaremos a MySQL
        String usuario = "root";
        
        // Contraseña del usuario para conectarse a la base de datos
        String contraseña = "root123";

        try {
            // Intentamos establecer una conexión con la base de datos usando la URL, usuario y contraseña
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            
            // Si la conexión es exitosa, mostramos un mensaje por consola
            System.out.println("¡Conexión exitosa!");
            
            // Retornamos el objeto Connection creado
            return conexion;
        } catch (SQLException e) {
            // Si ocurre algún error al intentar conectar, mostramos el mensaje del error por consola
            System.out.println("Error de conexión: " + e.getMessage());
            
            // Retornamos null indicando que no se pudo establecer la conexión
            return null;
        }
    }
}
