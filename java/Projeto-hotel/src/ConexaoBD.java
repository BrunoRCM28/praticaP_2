import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD{
    private static final String URL = "jdbc:sqlserver://regulus.cotuca.unicamp.br:1433;databaseNome=BD23632; user=BD23632; password=BD23632; integratedSecurity=true; encrypt=true; trustServerCertificate=true; authenticationScheme=NTLM"; //
    private static final String USUARIO = "BD23632";
    private static final String SENHA = "BD23632";

    public static Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conexao = DriverManager.getConnection(URL);
            System.out.println("Conexão bem-sucedida com o banco de dados.");
            return conexao;

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Falha na conexão com o banco de dados: [ERRO] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
