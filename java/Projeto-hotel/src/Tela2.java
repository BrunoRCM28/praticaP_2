import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;


public class Tela2 extends JFrame {

    //abas
    JTabbedPane abas = new JTabbedPane();
    JPanel cadastro = new JPanel();
    JPanel reserva = new JPanel();

    //dados - Cadastro
    JTextField textNome;
    JTextField textSobrenome;
    JTextField textCPF;
    JTextField textTelefone;
    JTextField textRg;
    JTextField textEmail;
    JComboBox<String> generoComboBox;

    //dados - reserva
    JTextField textCpfClientes;
    JTextField textPessoas;
    JTextField textNumero;
    JTextField textCor;
    JTextField textModelo;
    JTextField textPlaca;
    JComboBox<String> carroComboBox;
    JTextArea textObservacoes;

    JComboBox<Integer> diaCheckin;
    JComboBox<String> mesCheckin;
    JComboBox<Integer> anoCheckin;
    JComboBox<Integer> diaCheckout;
    JComboBox<String> mesCheckout;
    JComboBox<Integer> anoCheckout;


    public Tela2() {
        janelaCadastro();
        janelaReserva();

        abas.addTab("Cadastro", cadastro);
        abas.addTab("Reserva", reserva);
        add(BorderLayout.CENTER, abas);

        setTitle("Cadastro");
        setSize(800, 620);
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

        textNome = new JTextField();
        textNome.setBounds(85, 100, 250, 30);
        textNome.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textNome);

        // Caixa de texto - Sobrenome
        JLabel sobrenome = new JLabel("SOBRENOME: ");
        sobrenome.setBounds(365, 90,200,50);
        sobrenome.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(sobrenome);

        textSobrenome = new JTextField();
        textSobrenome.setBounds(475, 100, 250, 30);
        textSobrenome.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textSobrenome);

        // Caixa de texto - cpf
        JLabel cpf = new JLabel("CPF: ");
        cpf.setBounds(12, 160,200,50);
        cpf.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(cpf);

        textCPF = new JTextField();
        textCPF.setBounds(85, 170, 250, 30);
        textCPF.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textCPF);

        // Caixa de texto - rg
        JLabel rg = new JLabel("RG: ");
        rg.setBounds(365, 160,200,50);
        rg.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(rg);

        textRg = new JTextField();
        textRg.setBounds(475, 170, 250, 30);
        textRg.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textRg);

        // Caixa de texto - Email
        JLabel email = new JLabel("E-MAIL: ");
        email.setBounds(12, 230,200,50);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(email);

        textEmail = new JTextField();
        textEmail.setBounds(85, 240, 250, 30);
        textEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        cadastro.add(textEmail);

        // Caixa de texto - telefone
        JLabel telefone = new JLabel("TELEFONE: ");
        telefone.setBounds(365, 230,200,50);
        telefone.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(telefone);

        textTelefone = new JTextField();
        textTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
        textTelefone.setBounds(475, 240, 250, 30);
        cadastro.add(textTelefone);

        // Caixa de seleção - Gênero
        String[] generos = {"Masculino", "Feminino", "Outro"};
        JLabel generoLabel = new JLabel("GÊNERO: ");
        generoLabel.setBounds(12, 300, 200, 50);
        generoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cadastro.add(generoLabel);

        generoComboBox = new JComboBox<>(generos);
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
        jButton.addActionListener(this::inserir);
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

        textCpfClientes = new JTextField();
        textCpfClientes.setBounds(150, 100, 250, 30);
        textCpfClientes.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textCpfClientes);

        // Caixa de texto - pessoas no quarto
        JLabel pessoas = new JLabel("QUATIDADE DE PESSOAS: ");
        pessoas.setBounds(405, 90,200,50);
        pessoas.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(pessoas);

        textPessoas = new JTextField();
        textPessoas.setBounds(605, 100, 150, 30);
        textPessoas.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textPessoas);

        // Caixa de texto - Número do quarto
        JLabel numero = new JLabel("N° DO QUARTO: ");
        numero.setBounds(12, 160,200,50);
        numero.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(numero);

        textNumero = new JTextField();
        textNumero.setBounds(135, 170, 120, 30);
        textNumero.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textNumero);

        // Caixa de texto - cor carro
        JLabel cor = new JLabel("COR DO CARRO: ");
        cor.setBounds(442, 160,200,50);
        cor.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(cor);

        textCor = new JTextField();
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

        textModelo = new JTextField();
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

        textPlaca = new JTextField();
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

        carroComboBox = new JComboBox<>(carro);
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
        JLabel observacoes = new JLabel("<html>OBSERVAÇÕES <br>SOBRE O QUARTO: </html>");
        observacoes.setBounds(12, 300,200,50);
        observacoes.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(observacoes);

        textObservacoes = new JTextArea();
        textObservacoes.setLineWrap(true);
        textObservacoes.setWrapStyleWord(true);
        textObservacoes.setBounds(165, 310, 250, 130);
        textObservacoes.setFont(new Font("Arial", Font.PLAIN, 13));
        reserva.add(textObservacoes);

        //Chacek Box - data checkin
        JLabel dataLabel = new JLabel("CHECKIN: ");
        dataLabel.setBounds(430, 300, 200, 50);
        dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(dataLabel);

        diaCheckin = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            diaCheckin.addItem(i);
        }
        diaCheckin.setBounds(515, 310, 50, 30);
        reserva.add(diaCheckin);

        String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        mesCheckin = new JComboBox<>(months);
        mesCheckin.setBounds(575, 310, 100, 30);
        reserva.add(mesCheckin);

        anoCheckin = new JComboBox<>();
        int currentYear = LocalDate.now().getYear();
        anoCheckin.addItem(currentYear);
        anoCheckin.setBounds(685, 310, 70, 30);
        reserva.add(anoCheckin);


        //Chacek Box - data Checkout
        JLabel dataCheck = new JLabel("CHECKOUT: ");
        dataCheck.setBounds(425, 370, 200, 50);
        dataCheck.setFont(new Font("Arial", Font.BOLD, 15));
        reserva.add(dataCheck);

        diaCheckout = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            diaCheckout.addItem(i);
        }
        diaCheckout.setBounds(520, 380, 50, 30);
        reserva.add(diaCheckout);

        String[] mesCheck = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        mesCheckout = new JComboBox<>(months);
        mesCheckout.setBounds(580, 380, 100, 30);
        reserva.add(mesCheckout);

        anoCheckout = new JComboBox<>();
        int anoCheck = LocalDate.now().getYear();
        anoCheckout.addItem(currentYear);
        anoCheckout.setBounds(690, 380, 70, 30);
        reserva.add(anoCheckout);


        // Botão de Reserva
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
        jButton.addActionListener(this::inserirReserva);
    }

    public void entrar(ActionEvent actionEvent){
        Connection conexao = ConexaoBD.conectar();

        ConexaoBD selectBD = new ConexaoBD();
        selectBD.setConexao(conexao);

        selectBD.select();

    }

    public void inserir(ActionEvent actionEvent){
        if (textNome.getText().isEmpty() || textSobrenome.getText().isEmpty() || textCPF.getText().isEmpty() || textTelefone.getText().isEmpty() || textRg.getText().isEmpty() || textEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos precisam estar preenchidos para fazer o cadastro.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            Connection conexao = ConexaoBD.conectar();
            ConexaoBD inserirBD = new ConexaoBD();
            inserirBD.setConexao(conexao);

            String nome = textNome.getText();
            String sobrenome = textSobrenome.getText();

            String cpfString = textCPF.getText().trim();
            long cpf = Long.parseLong(cpfString);

            String telefoneString = textTelefone.getText().trim();
            long telefone = Long.parseLong(telefoneString);

            String rgString = textRg.getText().trim();
            long rg = Long.parseLong(rgString);

            String email = textEmail.getText();
            char sexo;

            if (generoComboBox.getSelectedItem().equals("Masculino")){
                sexo = 'M';
            }else if(generoComboBox.getSelectedItem().equals("Feminino")){
                sexo = 'F';
            }else{
                sexo = 'O';
            }

            inserirBD.insertHospede(nome, sobrenome, cpf, telefone, email, rg, sexo);
        }
    }


    public void inserirReserva(ActionEvent actionEvent){
        if (textCpfClientes.getText().isEmpty() || textPessoas.getText().isEmpty() || textNumero.getText().isEmpty() || textCor.getText().isEmpty() || textModelo.getText().isEmpty() || textPlaca.getText().isEmpty() || textObservacoes.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos precisam estar preenchidos para fazer a reserva.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            Connection conexao = ConexaoBD.conectar();
            ConexaoBD inserirBD = new ConexaoBD();
            inserirBD.setConexao(conexao);

            String cpfString = textCpfClientes.getText().trim();
            long cpf = Long.parseLong(cpfString);

            String numeroString = textNumero.getText().trim();
            int numero = Integer.parseInt(numeroString);

            String pessoasString = textPessoas.getText().trim();
            int pessoas = Integer.parseInt(pessoasString);

            String observacao = textObservacoes.getText();

            int diaEntrada = (int)diaCheckin.getSelectedItem();
            String mesEntrada = (String) mesCheckin.getSelectedItem();
            int mes;
            switch (mesEntrada){
                case "Janeiro":
                    mes = 1;
                    break;
                case "Favereiro":
                    mes = 2;
                    break;
                case "Março":
                    mes = 3;
                    break;
                case "Abril":
                    mes = 4;
                    break;
                case "Maio":
                    mes = 5;
                    break;
                case "Junho":
                    mes = 6;
                    break;
                case "Julho":
                    mes = 7;
                    break;
                case "Agosto":
                    mes = 8;
                    break;
                case "Setembro":
                    mes = 9;
                    break;
                case "Outubro":
                    mes = 10;
                    break;
                case "Novembro":
                    mes = 11;
                    break;
                case "Dezembro":
                    mes = 12;
                    break;
                default:
                    mes = 0;
            }
            int anoEntrada = (int)anoCheckin.getSelectedItem();

            int diaSaida = (int)diaCheckout.getSelectedItem();
            int mesSaida = (int)mesCheckout.getSelectedItem();
            int anoSaida = (int)anoCheckout.getSelectedItem();

            if (carroComboBox.getSelectedItem().equals("Sim")){
                String cor = textCor.getText();
                String modelo = textModelo.getText();
                String placa = textPlaca.getText();

                inserirBD.insertCarro(cpf, cor, modelo, placa);
            }

            inserirBD.insertReserva(cpf, numero, pessoas, observacao, diaEntrada, mes, anoEntrada, diaSaida, mesSaida, anoSaida);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tela2();
        });
    }

}
