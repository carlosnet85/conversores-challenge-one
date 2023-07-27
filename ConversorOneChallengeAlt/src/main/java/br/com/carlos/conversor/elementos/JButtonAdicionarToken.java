package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.carlos.conversor.funcoes.ConversorMoedasAPI;

@SuppressWarnings("serial")
public class JButtonAdicionarToken extends JButton {
	ConversorMoedasAPI c = new ConversorMoedasAPI();

	public JButtonAdicionarToken() {
		super("Token");
		setBounds(10, 420, 100, 30);
		setFont(new Font("Arial", Font.BOLD, 12));
		setBackground(new Color(20, 20, 20));
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.carregarToken();
			}
		});
	}
}