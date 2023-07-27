package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingWorker;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.ConversorMoedasAPI;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDeMoeda implements Conversao {
	private static final Map<String, String> fatorConversao = new HashMap<>();
	private static final Map<String, String> simbolo = new HashMap<>();
	private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
	private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

	private JTextFieldEntrada barraEntrada;

	ConversorMoedasAPI conversorMoeda = new ConversorMoedasAPI();

	static {
		fatorConversao.put("Real", "BRL");
		fatorConversao.put("Dolar", "USD");
		fatorConversao.put("Peso argentino", "ARS");
		fatorConversao.put("Peso chileno", "CLP");
		fatorConversao.put("Euro", "EUR");
		fatorConversao.put("Iene Japonês","JPY");
		fatorConversao.put("Won Coreano", "KRW");
		fatorConversao.put("Libra esterlina", "GBP");

	    simbolo.put("Real", "R$");
	    simbolo.put("Dolar", "US$");
	    simbolo.put("Peso argentino", "$ARS");
	    simbolo.put("Peso chileno", "$CLP"); 
	    simbolo.put("Euro", "€");
	    simbolo.put("Iene Japonês", "¥");
	    simbolo.put("Won Coreano", "₩");
	    simbolo.put("Libra esterlina", "£"); 
	}

	public ConversorDeMoeda(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
		this.listaUnidadeDe = listaUnidadeDe;
		this.listaUnidadePara = listaUnidadePara;
	}

	private Double arredondar(Double valor, int casasDecimais) {
		 if (valor == null) {
		        return 0.0;
		 } else {
		double arredondado = Math.round(valor * Math.pow(10, casasDecimais)) / Math.pow(10, casasDecimais);
		return arredondado;
	}

}

	@Override
	public String atualizarTexto(JTextFieldEntrada barraEntrada) {
		String moedaDe = listaUnidadeDe.getUnidade();
		String moedaPara = listaUnidadePara.getUnidade();

		Double valor = Double.parseDouble(barraEntrada.getValor());

		this.barraEntrada = barraEntrada;

		SwingWorker<Double, Void> swingWorker = new SwingWorker<>() {
			@Override
			protected Double doInBackground() throws Exception {
				return conversorMoeda.getConversaoMoedas(fatorConversao.get(moedaDe), fatorConversao.get(moedaPara),
						valor);
			}

			@Override
			protected void done() {
				try {
					Double resultado = get();
					atualizarResultado(resultado);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		swingWorker.execute();
		return "Aguarde...";
	}

	private void atualizarResultado(Double resultado) {
		String simboloMoeda = getSimbolo(listaUnidadePara.getUnidade());
		String textoResultado = simboloMoeda + " "
				+ new FormatarResultado().notacaoCientifica(arredondar(resultado, 2));
		barraEntrada.getBarraSaida().setText(textoResultado);
	}

	@Override
	public Double converter(String moedaDe, String moedaPara, Double valor) {
		return conversorMoeda.getConversaoMoedas(fatorConversao.get(moedaDe), fatorConversao.get(moedaPara), valor);
	}

	@Override
	public String getSimbolo(String moeda) {
		return simbolo.get(moeda);
	}
}