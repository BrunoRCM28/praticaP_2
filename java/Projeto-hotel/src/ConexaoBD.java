import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;

public class ConexaoBD{

    private Connection conexao;
    private ResultSet resultSet;
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

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void select() {
        String select = "select * from hotel.TipoQuarto";
        try {
            Statement statement = conexao.createStatement();
            resultSet = statement.executeQuery(select);

            StringBuilder resultados = new StringBuilder();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int colunas = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= colunas; i++) {
                    resultados.append(metaData.getColumnName(i))
                            .append(": ")
                            .append(resultSet.getString(i))
                            .append("\n");
                }
                resultados.append("\n");
            }
            JOptionPane.showMessageDialog(null, resultados.toString(), "Consulta bem-sucedida", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a consulta.", "Erro na consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void insertBD(String nome, String sobrenome, long cpf , long telefone, String email, long rg, char sexo) {
        String insert = "insert into hotel.Hospedes(prenome , sobrenome, cpf, telefone, e_mail, rg, sexo)" +
                        "values('"+nome+"', '"+sobrenome+"', "+cpf+", "+telefone+", '"+email+"', "+rg+", '"+sexo+"')";
        try {
            Statement statement = conexao.createStatement();
            int rowsAffected = statement.executeUpdate(insert);

            //StringBuilder resultados = new StringBuilder();
            //ResultSetMetaData metaData = resultSet.getMetaData();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no cadastro.", "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar o cadastro.", "Erro no cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

