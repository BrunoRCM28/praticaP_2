import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoBD{
    private static final String URL = "jdbc:sqlserver://regulus.cotuca.unicamp.br:1433; databaseNome=BD23632; user=BD23632; password=BD23632; encrypt=true; trustServerCertificate=true;";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL);
            System.out.println("Conexão bem-sucedida com o banco de dados.");
            return conexao;

        } catch (SQLException e) {
            System.err.println("Falha na conexão com o banco de dados: [ERRO] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void select(){
        String select = "select * from hotel.TipoQuarto";
        try{
            Statement statement = conexao.createStatement();
            resultSet = statement.executeQuery(select);
        }

    }
}
