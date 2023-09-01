package ClienteDAO;

import model.Cliente;

import java.sql.*;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardarCliente(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO cliente (nombrecliente, apellidocliente) VALUES (?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstm.setString(1,cliente.getNombre());
        pstm.setString(2,cliente.getApellido());
        pstm.execute();

        ResultSet rst = pstm.getGeneratedKeys();

        while(rst.next()){
            cliente.setId(rst.getInt(1));
        }

        connection.close();

    }


}
