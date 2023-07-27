package br.com.carlos.conversor.funcoes;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.com.carlos.conversor.elementos.JTextFieldEntrada;

public class ValorValido {

	private JTextFieldEntrada barraEntrada;
	private String input;

	public ValorValido(JTextFieldEntrada barraEntrada, String input) {
		this.barraEntrada = barraEntrada;
		this.input = input;
	}

	public boolean isValid() {
		try {
			barraEntrada.setForeground(Color.WHITE);
			if (input.matches("^-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?$")) {
				if (Double.isInfinite(Double.parseDouble(input))) {
					mostrarDialogoErro("Não utilize valores infinitos :)");
					limparTexto();
					return false;
				}
				return true;
			} else {
				barraEntrada.setForeground(Color.RED);
				return false;
			}
		} catch (NumberFormatException e) {
			barraEntrada.setForeground(Color.RED);
			return false;
		}
	}

	private void mostrarDialogoErro(String message) {
		barraEntrada.setForeground(Color.RED);
		JOptionPane.showMessageDialog(null, message, null, JOptionPane.ERROR_MESSAGE);
	}

	private void limparTexto() {
		SwingUtilities.invokeLater(() -> {
			barraEntrada.setText("");
		});
	}
}
