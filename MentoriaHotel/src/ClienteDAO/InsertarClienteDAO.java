package ClienteDAO;

import FabricaConexiones.CrearConexion;
import model.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertarClienteDAO {

    public static void main(String[] args) throws SQLException {

        CrearConexion crearConexion = new CrearConexion();

        Cliente cli1 = new Cliente("Paz", "Benavidez");
        Cliente cli2 = new Cliente("Marcos", "Galperin");

        Connection connection = crearConexion.recuperarConexion();
        new ClienteDAO(connection).guardarCliente(cli1);
        System.out.println(cli1);

    }



}
