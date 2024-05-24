package ex2;

import ex1.FatorialView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testes {

    FatorialView fatorialView;
    JButton calculateButton;
    JTextField inputField;
    JTextArea resultArea;

    @BeforeEach
    public void setUp() {
        fatorialView = new FatorialView();
        calculateButton = fatorialView.getButton();
        inputField = fatorialView.getInputField();
        resultArea = fatorialView.getResultArea();
    }

    @Test
    public void testFatorial() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            inputField.setText("10");
            calculateButton.doClick();
        });
        Thread.sleep(100); // Permite tempo para a atualização da interface
        assertEquals("Resultado: 3628800", resultArea.getText());
    }

    @Test
    public void testFatorialNegative() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            inputField.setText("-10");
            calculateButton.doClick();
        });
        Thread.sleep(100); // Permite tempo para a atualização da interface
        assertEquals("Erro de Entrada.", resultArea.getText());
    }
}