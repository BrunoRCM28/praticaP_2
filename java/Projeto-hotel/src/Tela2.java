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
        reserva.setLayout(null);
        JLabel titulo = new JLabel("RESERVA");
        titulo.setBounds(10,5,500,50);
        titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        titulo.setBorder(border);
        reserva.add(titulo);


        // Caixa de texto - cpf
        JLabel cpfClientes = new JLabel("CPF DO CLIENTE: ");
        cpfClientes.setBounds(12, 90,200,50);
        cpfClientes.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(cpfClientes);

        JTextField textCpfClientes = new JTextField("Escreva Aqui");
        textCpfClientes.setBounds(150, 100, 250, 30);
        textCpfClientes.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textCpfClientes);

        // Caixa de texto - pessoas no quarto
        JLabel pessoas = new JLabel("QUATIDADE DE PESSOAS: ");
        pessoas.setBounds(405, 90,200,50);
        pessoas.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(pessoas);

        JTextField textPessoas = new JTextField("Escreva aqui");
        textPessoas.setBounds(605, 100, 150, 30);
        textPessoas.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textPessoas);

        // Caixa de texto - Número do quarto
        JLabel numero = new JLabel("N° DO QUARTO: ");
        numero.setBounds(12, 160,200,50);
        numero.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(numero);

        JTextField textNumero = new JTextField("Escreva aqui");
        textNumero.setBounds(135, 170, 120, 30);
        textNumero.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textNumero);

        // Caixa de texto - cor carro
        JLabel cor = new JLabel("COR DO CARRO: ");
        cor.setBounds(442, 160,200,50);
        cor.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(cor);

        JTextField textCor = new JTextField("Escreva aqui");
        textCor.setBounds(574, 170, 180, 30);
        textCor.setFont(new Font("Arial", Font.PLAIN, 13));
        textCor.setEnabled(false);
        textCor.setBackground(new Color(204, 204, 204));
        textCor.setDisabledTextColor(Color.gray);
        reserva.add(textCor);

        // Caixa de texto - modelo
        JLabel modelo = new JLabel("MODELO DO CARRO: ");
        modelo.setBounds(365, 230,200,50);
        modelo.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(modelo);

        JTextField textModelo = new JTextField("Escreva aqui");
        textModelo.setBounds(530, 240, 225, 30);
        textModelo.setFont(new Font("Arial", Font.PLAIN, 13));
        textModelo.setEnabled(false);
        textModelo.setBackground(new Color(204, 204, 204));
        textModelo.setDisabledTextColor(Color.gray);
        reserva.add(textModelo);

        // Caixa de texto - placa
        JLabel placa = new JLabel("PLACA DO CARRO: ");
        placa.setBounds(12, 230,200,50);
        placa.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(placa);

        JTextField textPlaca = new JTextField("Escreva aqui");
        textPlaca.setBounds(155, 240, 200, 30);
        textPlaca.setFont(new Font("Arial", Font.PLAIN, 13));
        textPlaca.setEnabled(false);
        textPlaca.setBackground(new Color(204, 204, 204));
        textPlaca.setDisabledTextColor(Color.gray);
        reserva.add(textPlaca);

        // Caixa de seleção - carro
        String[] carro = {"Não", "Sim"};
        JLabel carroLabel = new JLabel("CARRO: ");
        carroLabel.setBounds(265, 160, 200, 50);
        carroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(carroLabel);

        JComboBox<String> carroComboBox = new JComboBox<>(carro);
        carroComboBox.setBounds(330, 170, 100, 30);
        carroComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        carroComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reserva.add(carroComboBox);

        carroComboBox.addActionListener(e -> {
            String selectedValue = (String) carroComboBox.getSelectedItem();

            if(selectedValue.equals("Sim")){
                textCor.setEnabled(true);
                textCor.setBackground(Color.WHITE);

                textModelo.setEnabled(true);
                textModelo.setBackground(Color.WHITE);

                textPlaca.setEnabled(true);
                textPlaca.setBackground(Color.WHITE);

            }else if (selectedValue.equals("Não")){
                textCor.setEnabled(false);
                textCor.setBackground(new Color(204, 204, 204));
                textCor.setDisabledTextColor(Color.gray);

                textModelo.setEnabled(false);
                textModelo.setBackground(new Color(204, 204, 204));
                textModelo.setDisabledTextColor(Color.gray);

                textPlaca.setEnabled(false);
                textPlaca.setBackground(new Color(204, 204, 204));
                textPlaca.setDisabledTextColor(Color.gray);
            }

        });


        // Caixa de texto - observação
        JLabel rg = new JLabel("<html>OBSERVAÇÕES <br>SOBRE O QUARTO: </html>");
        rg.setBounds(12, 300,200,50);
        rg.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(rg);

        JTextArea textRg = new JTextArea("Escreva aqui");
        textRg.setLineWrap(true);
        textRg.setWrapStyleWord(true);
        textRg.setBounds(165, 310, 450, 130);
        textRg.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textRg);


        // Botão de Cadastro
        JButton jButton = new JButton("FAZER RESERVA");
        jButton.setBounds(300, 470, 150, 50);
        jButton.setFont(new Font("Arial", Font.BOLD, 14));
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
        reserva.add(jButton);
        jButton.addActionListener(this::teste);
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
