package conversor.unidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conversor.unidade.metodo.moeda.Conversao;
import conversor.unidade.metodo.moeda.ConverterDolaresParaReais;
import conversor.unidade.metodo.moeda.ConverterEurosParaReais;
import conversor.unidade.metodo.moeda.ConverterLibrasParaReais;
import conversor.unidade.metodo.moeda.ConverterReaisParaDolares;
import conversor.unidade.metodo.moeda.ConverterReaisParaEuros;
import conversor.unidade.metodo.moeda.ConverterReaisParaLibras;
import conversor.unidade.metodo.moeda.ConverterReaisParaWonCoreano;
import conversor.unidade.metodo.moeda.ConverterReaisParaYenes;
import conversor.unidade.metodo.moeda.ConverterWonCoreanoParaReais;
import conversor.unidade.metodo.moeda.ConverterYenesParaReais;

public class ConversorMoedas {
	protected BigDecimal valor;
	protected String simbolo;

	public ConversorMoedas() {
		List<Conversao> conversoesMoeda = new ArrayList<>();
		conversoesMoeda.add(new ConverterReaisParaDolares());
		conversoesMoeda.add(new ConverterReaisParaEuros());
		conversoesMoeda.add(new ConverterReaisParaLibras());
		conversoesMoeda.add(new ConverterReaisParaWonCoreano());
		conversoesMoeda.add(new ConverterReaisParaYenes());
		conversoesMoeda.add(new ConverterDolaresParaReais());
		conversoesMoeda.add(new ConverterEurosParaReais());
		conversoesMoeda.add(new ConverterLibrasParaReais());
		conversoesMoeda.add(new ConverterWonCoreanoParaReais());
		conversoesMoeda.add(new ConverterYenesParaReais());

		String[] opcoes = new String[conversoesMoeda.size()];
		for (int i = 0; i < conversoesMoeda.size(); i++) {
			opcoes[i] = conversoesMoeda.get(i).getFuncao();
		}

		String escolha = (String) JOptionPane.showInputDialog(null,
				"Escolha a moeda para a qual você deseja girar seu dinheiro", "Moedas", JOptionPane.PLAIN_MESSAGE, null,
				opcoes, opcoes[0]);

		if (escolha != null) {
			for (Conversao conversao : conversoesMoeda) {
				if (conversao.getFuncao().equals(escolha)) {
					this.valor = conversao.getValorConversao();
					this.simbolo = conversao.getSimbolo();
					break;
				}
			}

			JOptionPane.showInternalMessageDialog(null, "O valor da conversão é de " + this.simbolo + this.valor);
		}
	}
}