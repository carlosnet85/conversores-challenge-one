package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

import conversor.painel.PainelInput;

public class ConverterWonCoreanoParaReais implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().multiply(new BigDecimal("0.0038"));
	}

	@Override
	public String getSimbolo() {
		return "R$";
	}

	@Override
	public String getFuncao() {
		return "De Won Coreano a Reais";
	}
}
