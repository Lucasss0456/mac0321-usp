package ex1;

import javax.swing.*;
import java.math.BigDecimal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FatorialView extends JFrame {
    private static final long serialVersionUID = 6265594525071196118L;
    private JTextField inputField;
    private JButton calcularButton;
    private JTextArea resultadoLabel;

    public FatorialView() {
        configurarJanela();
        criarComponentesInterface();
        adicionarComponentesJanela();
        calcularButton.addActionListener(new BotaoNaEscuta());
    }

    public void configurarJanela() {
        setTitle("Calculadora de Fatorial");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
    }

    private void criarComponentesInterface() {
        inputField = new JTextField();
        calcularButton = new JButton("Calcular");
        resultadoLabel = new JTextArea();
        resultadoLabel.setEditable(false);
    }

    private void adicionarComponentesJanela() {
        add(new JLabel("Digite um número:"));
        add(inputField);
        add(calcularButton);
        add(new JScrollPane(resultadoLabel));
    }

    // Métodos getter para Testes.java
    public JButton getButton() {
        return calcularButton;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JTextArea getResultArea() {
        return resultadoLabel;
    }

    class BotaoNaEscuta implements ActionListener {
        public BotaoNaEscuta() {
        }

        private int leNumero() {
            String inputText = inputField.getText();
            int n = Integer.parseInt(inputText);
            if (n < 0) {
                throw new IllegalArgumentException("O número não pode ser negativo.");
            }
            return n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int number = leNumero();
                BigDecimal result = FatorialController.calcularFatorial(number);
                resultadoLabel.setText("Resultado: " + result.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(FatorialView.this,
                        "Por favor, insira um número inteiro válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                resultadoLabel.setText("Erro de Entrada.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(FatorialView.this, ex.getMessage(),
                        "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                resultadoLabel.setText("Erro de Entrada.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FatorialView().setVisible(true));
    }
}
