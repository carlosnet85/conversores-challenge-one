package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

import conversor.painel.PainelInput;

public class ConverterReaisParaYenes implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().multiply(new BigDecimal("29"));
	}

	@Override
	public String getSimbolo() {
		return "¥";
	}

	@Override
	public String getFuncao() {
		return "De Reais a Yenes";
	}
}
