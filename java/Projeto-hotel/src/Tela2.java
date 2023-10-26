import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


public class Tela2 extends JFrame {

    JTabbedPane abas = new JTabbedPane();
    JPanel cadastro = new JPanel();
    JPanel reserva = new JPanel();

    public Tela2() {
        janelaCadastro();
        janelaReserva();
        abas.addTab("Cadastro", cadastro);
        abas.addTab("Reserva", reserva);
        add(BorderLayout.CENTER, abas);

        setTitle("Cadastro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void janelaCadastro() {
        cadastro.setLayout(null);
        JLabel titulo = new JLabel("CADASTRO DE HOSPEDES");
        titulo.setBounds(10,5,500,50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        titulo.setBorder(border);
        cadastro.add(titulo);


        // Caixa de texto - Nome
        JLabel nome = new JLabel("NOME: ");
        nome.setBounds(12, 90,200,50);
        nome.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(nome);

        JTextField textNome = new JTextField("Escreva Aqui");
        textNome.setBounds(85, 100, 250, 30);
        textNome.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textNome);

        // Caixa de texto - Sobrenome
        JLabel sobrenome = new JLabel("SOBRENOME: ");
        sobrenome.setBounds(365, 90,200,50);
        sobrenome.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(sobrenome);

        JTextField textSobrenome = new JTextField("Escreva aqui");
        textSobrenome.setBounds(475, 100, 250, 30);
        textSobrenome.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textSobrenome);

        // Caixa de texto - cpf
        JLabel cpf = new JLabel("CPF: ");
        cpf.setBounds(12, 160,200,50);
        cpf.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(cpf);

        JTextField textCPF = new JTextField("Escreva aqui");
        textCPF.setBounds(85, 170, 250, 30);
        textCPF.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textCPF);

        // Caixa de texto - rg
        JLabel rg = new JLabel("RG: ");
        rg.setBounds(365, 160,200,50);
        rg.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(rg);

        JTextField textRg = new JTextField("Escreva aqui");
        textRg.setBounds(475, 170, 250, 30);
        textRg.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textRg);

        // Caixa de texto - Email
        JLabel email = new JLabel("E-MAIL: ");
        email.setBounds(12, 230,200,50);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(email);

        JTextField textEmail = new JTextField("Escreva aqui");
        textEmail.setBounds(85, 240, 250, 30);
        textEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textEmail);

        // Caixa de texto - telefone
        JLabel telefone = new JLabel("TELEFONE: ");
        telefone.setBounds(365, 230,200,50);
        telefone.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(telefone);

        JTextField textTelefone = new JTextField("Escreva aqui");
        textTelefone.setBounds(475, 240, 250, 30);
        textTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textTelefone);

        // Caixa de seleção - Gênero
        String[] generos = {"Masculino", "Feminino", "Outro"};
        JLabel generoLabel = new JLabel("GÊNERO: ");
        generoLabel.setBounds(12, 300, 200, 50);
        generoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(generoLabel);

        JComboBox<String> generoComboBox = new JComboBox<>(generos);
        generoComboBox.setBounds(85, 310, 150, 30);
        generoComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        generoComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cadastro.add(generoComboBox);



        // Botão de Cadastro
        JButton jButton = new JButton("Cadastrar");
        jButton.setBounds(300, 400, 140, 40);
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
        cadastro.add(jButton);
        jButton.addActionListener(this::teste);
    }

    public void janelaReserva(){
    }

    public void teste(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Grande dia", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Grande dia");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tela2();
        });
    }
}
