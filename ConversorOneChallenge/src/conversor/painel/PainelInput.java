package conversor.painel;

import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PainelInput extends JFrame {
	private BigDecimal input;

	public PainelInput() {
		converterInput();
	}

	private void converterInput() {
		try {
			String valor = JOptionPane.showInputDialog("Insira um valor");
			if (valor == null) {
				System.exit(0);
			} else {
				valor = valor.trim();

				if (valor.length() > 30) {
					throw new NumberFormatException();
				}

				BigDecimal valorReal = new BigDecimal(valor);
				if (valorReal.compareTo(BigDecimal.ZERO) < 0) {
					throw new IllegalArgumentException();
				}
				this.input = valorReal;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor muito grande (maior que 30 digitos)", "Erro",
					JOptionPane.ERROR_MESSAGE);
			converterInput();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido", "Erro", JOptionPane.ERROR_MESSAGE);
			converterInput();

		}
	}

	public BigDecimal getInput() {
		return this.input;
	}
}