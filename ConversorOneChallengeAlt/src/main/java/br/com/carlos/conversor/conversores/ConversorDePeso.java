package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDePeso implements Conversao {
	private static final Map<String, Double> fatorConversao = new HashMap<>();
	private static final Map<String, String> Simbolo = new HashMap<>();
	private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
	private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

	static {
		fatorConversao.put("Miligrama", 1.0);
		fatorConversao.put("Grama", 1000.0);
		fatorConversao.put("Quilograma", 1000000.0);
		fatorConversao.put("Tonelada", 1000000000.0);
        fatorConversao.put("Decagrama", 10000.0);
        fatorConversao.put("Hectograma", 100000.0);
        
		Simbolo.put("Miligrama", "mg");
		Simbolo.put("Grama", "g");
		Simbolo.put("Quilograma", "kg");
		Simbolo.put("Tonelada", "ton");
        Simbolo.put("Decagrama", "dag");
        Simbolo.put("Hectograma", "hg");
	}

	public ConversorDePeso(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
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
