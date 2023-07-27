package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelPergunta extends JLabel {

	public JLabelPergunta() {
		super("O que deseja converter?");
		setFont(new Font("Arial", Font.BOLD, 20));
		setForeground(Color.WHITE);
		setBounds(20, 100, 300, 40);
	}

}
