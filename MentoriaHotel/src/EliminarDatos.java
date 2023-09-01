import FabricaConexiones.CrearConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarDatos {
    public static void main(String[] args) throws SQLException {

        CrearConexion crearConexion = new CrearConexion();
        Connection connection = crearConexion.recuperarConexion();

        PreparedStatement pstm = connection.prepareStatement(
                "DELETE FROM cliente WHERE idcliente = ?"
        );

        pstm.setInt(1,2);
        pstm.execute();

        Integer lineasEliminadas = pstm.getUpdateCount();
        System.out.println("Lineas eliminadas: " + lineasEliminadas);

        connection.close();
    }
}
