package ex2;

import ex1.FatorialView;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testes {
	

	FatorialView fatorialView = new FatorialView();
	
	
	JButton calculateButton = fatorialView.getButton();
	JTextField inputField = fatorialView.getInputField();
	JTextArea resultArea = fatorialView.getResultArea();
	
   
	
	@BeforeEach
	public void setUp() {
		
        FatorialView janela = new FatorialView();

        System.out.println("Aqui");
		calculateButton = janela.getButton();
		inputField = janela.getInputField();
		resultArea = janela.getResultArea();
		
	}

    @Test
    public void testFatorial() throws Exception {
    	
    	SwingUtilities.invokeAndWait(() -> {
            inputField.setText("10");
            calculateButton.doClick();
        });
        Thread.sleep(100); // Allow time for the calculation to complete
        assertEquals("Resultado: 3628800", resultArea.getText());
    }
    	
    
    
    @Test
    public void testFatorialNegative() throws InterruptedException {
    	inputField.setText("-10");
    	calculateButton.doClick();
    	Thread.sleep(100);
    	assertEquals("Erro de Entrada.", resultArea.getText());
    	}
    
	
	}