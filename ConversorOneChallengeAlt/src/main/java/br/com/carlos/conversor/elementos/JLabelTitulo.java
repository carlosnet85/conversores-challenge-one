package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelTitulo extends JLabel {

	public JLabelTitulo() {
		super("Conversor de unidade");

		Map<TextAttribute, Object> estiloFonte = new HashMap<>();
		estiloFonte.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		estiloFonte.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);

		setBounds(75, 10, 300, 80);
		setForeground(Color.WHITE);
		setFont(new Font("Times New Roman", Font.PLAIN, 30).deriveFont(estiloFonte));

	}
}
