import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    // Configurações de conexão
    private static final String URL = "jdbc:sqlserver://seuServidor:porta;databaseName=seuBanco";
    private static final String USUARIO = "seuUsuario";
    private static final String SENHA = "suaSenha";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // ou lançar uma exceção personalizada, dependendo do caso
        }
    }

    public static void desconectar(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
