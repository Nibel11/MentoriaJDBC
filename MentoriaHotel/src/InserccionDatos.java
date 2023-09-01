import FabricaConexiones.CrearConexion;

import java.sql.*;

public class InserccionDatos {
    public static void main(String[] args) throws SQLException {

        String nombre = "Florencia";
        String apellido = "Rabonni";

        CrearConexion crearConexion = new CrearConexion();
        Connection connection = crearConexion.recuperarConexion();

        PreparedStatement pstm = connection.prepareStatement(
                "INSERT INTO cliente (nombrecliente, apellidocliente) VALUES (?,?)",
                Statement.RETURN_GENERATED_KEYS
        );

        pstm.setString(1,nombre);
        pstm.setString(2, apellido);
        pstm.execute();

        ResultSet rst = pstm.getGeneratedKeys();

        while(rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("Información cargada \n" + "Id: " + id);
        }

        connection.close();

    }
}
