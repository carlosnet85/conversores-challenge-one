package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelPara extends JLabel {

	public JLabelPara() {
		super("Para:");
		setBounds(10, 280, 300, 50);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setForeground(Color.WHITE);

	}
}
