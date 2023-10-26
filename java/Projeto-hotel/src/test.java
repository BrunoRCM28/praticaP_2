import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class test extends JFrame {

    JTabbedPane abas = new JTabbedPane();
    JPanel cadastro = new JPanel();
    JPanel reserva = new JPanel();

    public test() {
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

        // Título
        JLabel titulo = new JLabel("CADASTRO DE HÓSPEDES");
        titulo.setBounds(250, 10, 300, 50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        cadastro.add(titulo);

        // Nome
        JLabel nome = new JLabel("NOME: ");
        nome.setBounds(50, 70, 100, 30);
        nome.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(nome);

        JTextField textNome = new JTextField();
        textNome.setBounds(150, 70, 200, 30);
        textNome.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textNome);

        // Sobrenome
        JLabel sobrenome = new JLabel("SOBRENOME: ");
        sobrenome.setBounds(400, 70, 100, 30);
        sobrenome.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(sobrenome);

        JTextField textSobrenome = new JTextField();
        textSobrenome.setBounds(500, 70, 200, 30);
        textSobrenome.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textSobrenome);

        // CPF
        JLabel cpf = new JLabel("CPF: ");
        cpf.setBounds(50, 120, 100, 30);
        cpf.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(cpf);

        JTextField textCPF = new JTextField();
        textCPF.setBounds(150, 120, 200, 30);
        textCPF.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textCPF);

        // RG
        JLabel rg = new JLabel("RG: ");
        rg.setBounds(400, 120, 100, 30);
        rg.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(rg);

        JTextField textRg = new JTextField();
        textRg.setBounds(500, 120, 200, 30);
        textRg.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textRg);

        // E-mail
        JLabel email = new JLabel("E-MAIL: ");
        email.setBounds(50, 170, 100, 30);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(email);

        JTextField textEmail = new JTextField();
        textEmail.setBounds(150, 170, 200, 30);
        textEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textEmail);

        // Telefone
        JLabel telefone = new JLabel("TELEFONE: ");
        telefone.setBounds(400, 170, 100, 30);
        telefone.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(telefone);

        JTextField textTelefone = new JTextField();
        textTelefone.setBounds(500, 170, 200, 30);
        textTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textTelefone);

        // Gênero
        String[] generos = {"Masculino", "Feminino", "Outro"};
        JLabel generoLabel = new JLabel("GÊNERO: ");
        generoLabel.setBounds(50, 220, 100, 30);
        generoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(generoLabel);

        JComboBox<String> generoComboBox = new JComboBox<>(generos);
        generoComboBox.setBounds(150, 220, 200, 30);
        generoComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(generoComboBox);

        // Botão de Cadastro
        JButton jButton = new JButton("Cadastrar");
        jButton.setBounds(330, 300, 140, 40);
        jButton.setFont(new Font("Arial", Font.BOLD, 15));
        jButton.setForeground(new Color(232, 16, 16));
        jButton.setBackground(new Color(255, 255, 255));
        cadastro.add(jButton);
        jButton.addActionListener(this::teste);
    }

    public void janelaReserva() {
        // Aqui você pode adicionar os componentes para a aba de reserva, se necessário.
    }

    public void teste(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Grande dia", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Grande dia");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new test();
        });
    }
}
