package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JButtonGithub extends JButton {

	public JButtonGithub() {
		super("Github");
		setIcon(new ImageIcon("src/main/java/br/com/carlos/convesor/resources/github_mark_white.png"));
		setBounds(325, 420, 100, 30);
		setFont(new Font("Arial", Font.BOLD, 12));
		setBackground(new Color(20, 20, 20));
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addActionListener(e -> {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/carlosnet85/one-challenge-convesor-de-moeda"));
			} catch (IOException | URISyntaxException ex) {
				JOptionPane.showMessageDialog(null, "Não foi possível continuar com a operação", "Erro (Link inválido)",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}