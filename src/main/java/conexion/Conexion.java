package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/RepasoServidor1";
    private static final String USER = "root";
    private static final String PASS = "123456";

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el driver de la base de datos", e);
        }
    }

    /**
     * Obtiene una conexión activa a la base de datos.
     * 
     * @return Connection objeto de conexión SQL
     * @throws SQLException si ocurre un error de acceso a la BD
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
