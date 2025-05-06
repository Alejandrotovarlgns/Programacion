// Indicamos que este archivo forma parte del paquete llamado 'cine'
package cine;

// Importamos las clases necesarias para trabajar con bases de datos
import java.sql.Connection;     // Clase que representa una conexión a la base de datos
import java.sql.DriverManager;  // Clase que se usa para conectar con la base de datos
import java.sql.SQLException;   // Clase que representa errores relacionados con SQL

// Creamos la clase Conexion, que nos ayudará a conectar con la base de datos
public class Conexion {

    // Constante con la URL de conexión a la base de datos (tipo, servidor, puerto y nombre de la BD)
    private static final String URL = "jdbc:mysql://localhost:3306/cine_AlejandroTovar";

    // Usuario de la base de datos (en este caso, el root)
    private static final String USER = "root";

    // Contraseña del usuario para acceder a la base de datos
    private static final String PASSWORD = "root123"; 

    // Método público y estático que nos devuelve un objeto de tipo Connection
    public static Connection getConnection() throws SQLException {
        // Devuelve una conexión con la base de datos usando los datos anteriores
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
