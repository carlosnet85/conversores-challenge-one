package br.com.carlos.conversor.funcoes;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.carlos.conversor.conversores.Conversao;
import br.com.carlos.conversor.conversores.ConversorDeAngulo;
import br.com.carlos.conversor.conversores.ConversorDeArea;
import br.com.carlos.conversor.conversores.ConversorDeComprimento;
import br.com.carlos.conversor.conversores.ConversorDeMoeda;
import br.com.carlos.conversor.conversores.ConversorDePeso;
import br.com.carlos.conversor.conversores.ConversorDePressao;
import br.com.carlos.conversor.conversores.ConversorDeTemperatura;
import br.com.carlos.conversor.conversores.ConversorDeVelocidade;
import br.com.carlos.conversor.conversores.ConversorDeVolume;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JComboBoxUnidades;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.elementos.JTextFieldSaida;

public class AtualizarResultado {
	private static final Map<String, Class<? extends Conversao>> conversorMap = new HashMap<>();

	static {
		conversorMap.put("Massa", ConversorDePeso.class);
		conversorMap.put("Temperatura", ConversorDeTemperatura.class);
		conversorMap.put("Comprimento", ConversorDeComprimento.class);
		conversorMap.put("Volume", ConversorDeVolume.class);
		conversorMap.put("Área", ConversorDeArea.class);
		conversorMap.put("Velocidade", ConversorDeVelocidade.class);
		conversorMap.put("Moeda", ConversorDeMoeda.class);
		conversorMap.put("Pressão", ConversorDePressao.class);
		conversorMap.put("Ângulo", ConversorDeAngulo.class);
	}

	private JComboBoxUnidades listaCategoriasUnidade;
	private JComboBoxSubUnidadeDe listaUnidadeDe;
	private JComboBoxSubUnidadePara listaUnidadePara;
	private JTextFieldEntrada barraEntrada;
	private JTextFieldSaida barraSaida;

	public AtualizarResultado(JComboBoxUnidades listaCategoriasUnidade, JComboBoxSubUnidadeDe listaUnidadeDe,
			JComboBoxSubUnidadePara listaUnidadePara, JTextFieldEntrada barraEntrada, JTextFieldSaida barraSaida) {
		this.listaCategoriasUnidade = listaCategoriasUnidade;
		this.listaUnidadeDe = listaUnidadeDe;
		this.listaUnidadePara = listaUnidadePara;
		this.barraEntrada = barraEntrada;
		this.barraSaida = barraSaida;
	}

	public void atualizarResultado() {
		Class<? extends Conversao> conversorSelecionado = conversorMap
				.get(listaCategoriasUnidade.getSelectedItem().toString());

		try {
			Conversao conversor = conversorSelecionado
					.getDeclaredConstructor(JComboBoxSubUnidadeDe.class, JComboBoxSubUnidadePara.class)
					.newInstance(listaUnidadeDe, listaUnidadePara);

			barraSaida.setText(conversor.atualizarTexto(barraEntrada));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível continuar com a operação",
					"Erro (Parâmetro inválido)", JOptionPane.ERROR_MESSAGE);
		}
	}
}
