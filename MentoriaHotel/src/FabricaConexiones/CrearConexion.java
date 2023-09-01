package FabricaConexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearConexion {

    public Connection recuperarConexion() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/clientes?useTimezone=true&serverTimezone=UTC",
                "root", "francia1013"
        );

        return connection;
    }





}
