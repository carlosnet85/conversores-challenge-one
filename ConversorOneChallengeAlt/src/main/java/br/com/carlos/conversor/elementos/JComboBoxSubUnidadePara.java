package br.com.carlos.conversor.elementos;

import java.awt.Color;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class JComboBoxSubUnidadePara extends JComboBox<String> {

	public JComboBoxSubUnidadePara() {
		setBounds(280, 280, 150, 50);
		setBackground(new Color(20, 20, 20));
		setForeground(Color.WHITE);
	}

	public String getUnidade() {
		return getSelectedItem().toString();
	}
}
