package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

import conversor.painel.PainelInput;

public class ConverterReaisParaWonCoreano implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().multiply(new BigDecimal("265"));
	}

	@Override
	public String getSimbolo() {
		return "₩";
	}

	@Override
	public String getFuncao() {
		return "De Reais a Won Coreano";
	}
}
