package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelDe extends JLabel {

	public JLabelDe() {
		super("   De:");
		setBounds(10, 190, 300, 50);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setForeground(Color.WHITE);

	}

}
