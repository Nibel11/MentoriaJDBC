import FabricaConexiones.CrearConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarDatos {
    public static void main(String[] args) throws SQLException {

        CrearConexion crearConexion = new CrearConexion();
        Connection connection = crearConexion.recuperarConexion();

        PreparedStatement psmt = connection.prepareStatement(
                "SELECT idcliente, nombrecliente, apellidocliente FROM cliente"
        );
        psmt.execute();

        ResultSet rst = psmt.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("idcliente");
            String nombre = rst.getString("nombrecliente");
            String apellido = rst.getString("apellidocliente");

            System.out.println("Id:" + id + "Nombre: "+ nombre + "Apellido: " + apellido);

        }
        connection.close();
    }
}
