package br.com.carlos.conversor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import br.com.carlos.conversor.elementos.JButtonAdicionarToken;
import br.com.carlos.conversor.elementos.JButtonGithub;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JComboBoxUnidades;
import br.com.carlos.conversor.elementos.JLabelDe;
import br.com.carlos.conversor.elementos.JLabelPara;
import br.com.carlos.conversor.elementos.JLabelPergunta;
import br.com.carlos.conversor.elementos.JLabelTitulo;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.elementos.JTextFieldSaida;
import br.com.carlos.conversor.funcoes.AtualizarResultado;
import br.com.carlos.conversor.funcoes.ConversorMoedasAPI;
import br.com.carlos.conversor.funcoes.ValorValido;

@SuppressWarnings("serial")
public class ConversorApp extends JFrame {

	ConversorMoedasAPI conversorMoedas = new ConversorMoedasAPI();

	private JButtonGithub botaoGithub = new JButtonGithub();
	private JButtonAdicionarToken botaoG2 = new JButtonAdicionarToken();
	private JLabelTitulo titulo = new JLabelTitulo();
	private JLabelDe textoDe = new JLabelDe();
	private JLabelPara textoPara = new JLabelPara();
	private JLabelPergunta pergunta = new JLabelPergunta();
	private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
	private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();
	private JTextFieldSaida barraSaida = new JTextFieldSaida();
	private JComboBoxUnidades listaCategoriasUnidade = new JComboBoxUnidades(listaUnidadeDe, listaUnidadePara);
	private JTextFieldEntrada barraEntrada = new JTextFieldEntrada(listaCategoriasUnidade, barraSaida, listaUnidadeDe,
			listaUnidadePara);
	private AtualizarResultado atualizarResultado = new AtualizarResultado(listaCategoriasUnidade, listaUnidadeDe,
			listaUnidadePara, barraEntrada, barraSaida);

	public ConversorApp() {
		setTitle("Conversor de unidade");
		setSize(450, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(new Color(10, 10, 10));

		add(botaoGithub);
		add(textoDe);
		add(textoPara);
		add(barraSaida);
		add(pergunta);
		add(barraEntrada);
		add(titulo);
		add(listaUnidadePara);
		add(listaUnidadeDe);
		add(listaCategoriasUnidade);

		listaCategoriasUnidade.addActionListener(e -> SwingUtilities.invokeLater(() -> {
			barraEntrada.setText("");
			barraSaida.setText("");

			if (listaCategoriasUnidade.getSelectedItem().equals("Moeda")) {
				add(botaoG2);
				SwingUtilities.invokeLater(() -> {
					barraEntrada.setText("1");
				});
			} else {
				remove(botaoG2);
			}
			repaint();
			revalidate();

		}));

		listaUnidadeDe.addActionListener(e -> {
			if (listaUnidadeDe.getSelectedItem() != null && listaUnidadePara.getSelectedItem() != null) {
				if (new ValorValido(barraEntrada, barraEntrada.getText()).isValid())
					if (!barraEntrada.getText().isEmpty())
						atualizarResultado.atualizarResultado();
			}

		});

		listaUnidadePara.addActionListener(e -> {
			if (listaUnidadeDe.getSelectedItem() != null && listaUnidadePara.getSelectedItem() != null) {
				if (new ValorValido(barraEntrada, barraEntrada.getText()).isValid())
					if (!barraEntrada.getText().isEmpty())
						atualizarResultado.atualizarResultado();
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				new ConversorApp();

			}
		});
	}

}
