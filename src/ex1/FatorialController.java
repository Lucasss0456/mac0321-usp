package ex1;

import java.math.BigDecimal;

public class FatorialController {
	public static BigDecimal calcularFatorial(int numero) {
        BigDecimal resultado = BigDecimal.ONE;
        for (int i = 2; i <= numero; i++) {
            resultado = resultado.multiply(BigDecimal.valueOf(i));
        }
        return resultado;
    }

}