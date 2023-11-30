import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame{

    //Login - textos
    JTextField textUsuario;
    JPasswordField textSenha;

    public Login(){
        janelaLogin();

        setTitle("Cadastro");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void janelaLogin(){
        setLayout(null);
        JLabel titulo = new JLabel("LOGIN");
        titulo.setBounds(155,5,100,50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        add(titulo);

        //usuario
        JLabel usuario = new JLabel("USUÁRIO: ");
        usuario.setBounds(12, 90,200,50);
        usuario.setFont(new Font("Arial", Font.BOLD, 15));
        add(usuario);

        textUsuario = new JTextField("Escreva Aqui");
        textUsuario.setBounds(90, 100, 250, 30);
        textUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        add(textUsuario);

        //senha
        JLabel senha = new JLabel("SENHA: ");
        senha.setBounds(12, 160,200,50);
        senha.setFont(new Font("Arial", Font.BOLD, 15));
        add(senha);

        textSenha = new JPasswordField();
        textSenha.setBounds(90, 170, 250, 30);
        textSenha.setFont(new Font("Arial", Font.PLAIN, 13));
        add(textSenha);

        //Botão
        JButton jButton = new JButton("Entrar");
        jButton.setBounds(140, 230, 100, 35);
        jButton.setFont(new Font("Arial", Font.BOLD, 16));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(new Color(93, 96, 93));
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                jButton.setBackground(new Color(131, 134, 131));
            }

            public void mouseExited(MouseEvent e) {
                jButton.setBackground(new Color(93, 96, 93));
            }
        });
        add(jButton);
        jButton.addActionListener(this::verificacao);
    }

    public void verificacao(ActionEvent actionEvent) {
        String usuario = "BD23632";
        String senha = "BD23632";

        if(textUsuario.getText().equals(usuario) && textSenha.getText().equals(senha)){
            Tela2 janela = new Tela2();
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
    */
}
