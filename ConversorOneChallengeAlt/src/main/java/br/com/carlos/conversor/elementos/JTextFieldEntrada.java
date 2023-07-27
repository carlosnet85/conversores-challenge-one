package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.com.carlos.conversor.funcoes.AtualizarResultado;
import br.com.carlos.conversor.funcoes.ValorValido;

@SuppressWarnings("serial")
public class JTextFieldEntrada extends JTextField {

	private JComboBoxUnidades listaCategoriasUnidade;
	private JTextFieldSaida barraSaida;
	private JComboBoxSubUnidadeDe listaUnidadeDe;
	private JComboBoxSubUnidadePara listaUnidadePara;

	public JTextFieldEntrada(JComboBoxUnidades listaCategoriasUnidade, JTextFieldSaida barraSaida,
			JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
		setBounds(65, 190, 200, 50);
		setFont(new Font("Arial", Font.BOLD, 17));
		setBackground(new Color(20, 20, 20));
		setForeground(Color.WHITE);
		setBorder(new EmptyBorder(0, 10, 0, 0));

		this.listaCategoriasUnidade = listaCategoriasUnidade;
		this.barraSaida = barraSaida;
		this.listaUnidadeDe = listaUnidadeDe;
		this.listaUnidadePara = listaUnidadePara;

		getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (ehValido()) {
					atualizarResultado();
				} else barraSaida.setText("-");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (ehValido()) {
					atualizarResultado();
				} else barraSaida.setText("-");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (ehValido()) {
					atualizarResultado();
				} else barraSaida.setText("-");
			}
		});
	}

	private void atualizarResultado() {
		new AtualizarResultado(listaCategoriasUnidade, listaUnidadeDe, listaUnidadePara, this, barraSaida)
				.atualizarResultado();
	}

	private boolean ehValido() {
		return new ValorValido(this, this.getText()).isValid();
	}

	public String getValor() {
		return getText();
	}

	public JTextFieldSaida getBarraSaida() {
		return barraSaida;
	}
}
