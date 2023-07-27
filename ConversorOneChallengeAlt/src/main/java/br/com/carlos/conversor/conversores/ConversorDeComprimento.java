package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDeComprimento implements Conversao {
	private static final Map<String, Double> fatorConversao = new HashMap<>();
	private static final Map<String, String> Simbolo = new HashMap<>();
	private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
	private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

	static {
		fatorConversao.put("Milímetro", 1.0);
		fatorConversao.put("Centímetro", 10.0);
		fatorConversao.put("Metro", 1000.0);
		fatorConversao.put("Quilômetro", 1000000.0);
		fatorConversao.put("Decímetro", 100.0);
		fatorConversao.put("Nanômetro", 0.000001);

		Simbolo.put("Milímetro", "mm");
		Simbolo.put("Centímetro", "cm");
		Simbolo.put("Metro", "m");
		Simbolo.put("Quilômetro", "km");
		Simbolo.put("Decímetro", "dm");
		Simbolo.put("Nanômetro", "nm");
	}

	public ConversorDeComprimento(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
		this.listaUnidadeDe = listaUnidadeDe;
		this.listaUnidadePara = listaUnidadePara;
	}

	@Override
	public String atualizarTexto(JTextFieldEntrada barraEntrada) {
		Double resultado = converter(listaUnidadeDe.getUnidade(), listaUnidadePara.getUnidade(),
				Double.parseDouble(barraEntrada.getValor()));
		String simbolo = getSimbolo(listaUnidadePara.getUnidade());

		return new FormatarResultado().notacaoCientifica(resultado) + " " + simbolo;
	}

	@Override
	public Double converter(String unidadeDe, String unidadePara, Double proporcao) {
		return proporcao * fatorConversao.get(unidadeDe) / fatorConversao.get(unidadePara);
	}

	@Override
	public String getSimbolo(String unidade) {
		return Simbolo.get(unidade);
	}
}
