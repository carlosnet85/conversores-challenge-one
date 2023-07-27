package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JTextFieldSaida extends JTextField {

	public JTextFieldSaida() {
		setFont(new Font("Arial", Font.PLAIN, 17));
		setForeground(Color.WHITE);
		setBorder(new EmptyBorder(0, 0, 0, 10));
		setBounds(65, 280, 200, 50);
		setBackground(new Color(20, 20, 20));
		setHorizontalAlignment(SwingConstants.RIGHT);
		setEditable(false);
	}
}
