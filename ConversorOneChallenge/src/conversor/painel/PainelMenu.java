package conversor.painel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import conversor.unidade.ConversorMoedas;
import conversor.unidade.ConversorTemperatura;

@SuppressWarnings("serial")
public class PainelMenu extends JFrame {
	private void iniciarPrograma() {
		String[] opcoes = { "Conversor de Moedas", "Conversor de Temperatura" };
		String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

		if (escolha != null) {
			switch (escolha) {
			case "Conversor de Moedas":
				new ConversorMoedas();
				break;
			case "Conversor de Temperatura":
				new ConversorTemperatura();
				break;
			}

			int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", null, JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.YES_OPTION) {
				new PainelMenu();
			} else {
				JOptionPane.showMessageDialog(null, "Programa finalizado.");
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PainelMenu().iniciarPrograma();
			}
		});

	}
}