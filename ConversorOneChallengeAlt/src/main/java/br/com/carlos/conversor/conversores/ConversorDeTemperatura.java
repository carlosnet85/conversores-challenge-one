package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDeTemperatura implements Conversao {
	private static final Map<String, String> simbolo = new HashMap<>();
	private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
	private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

	static {
		simbolo.put("Celsius", "°C");
		simbolo.put("Fahrenheit", "°F");
		simbolo.put("Kelvin", "K");
	}

	public ConversorDeTemperatura(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {

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
	public Double converter(String unidadeDe, String unidadePara, Double valor) {
		if (unidadeDe.equals("Celsius")) {
			if (unidadePara.equals("Fahrenheit")) {
				return (valor * 9.0 / 5.0) + 32.0;
			} else if (unidadePara.equals("Kelvin")) {
				return valor + 273.15;
			}
		} else if (unidadeDe.equals("Fahrenheit")) {
			if (unidadePara.equals("Celsius")) {
				return (valor - 32.0) * 5.0 / 9.0;
			} else if (unidadePara.equals("Kelvin")) {
				return (valor + 459.67) * 5.0 / 9.0;
			}
		} else if (unidadeDe.equals("Kelvin")) {
			if (unidadePara.equals("Celsius")) {
				return valor - 273.15;
			} else if (unidadePara.equals("Fahrenheit")) {
				return (valor * 9.0 / 5.0) - 459.67;
			}
		}
		return valor;
	}

	@Override
	public String getSimbolo(String unidade) {
		return simbolo.get(unidade);
	}
}
