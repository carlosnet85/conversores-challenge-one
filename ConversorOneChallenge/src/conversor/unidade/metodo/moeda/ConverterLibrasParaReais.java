package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

import conversor.painel.PainelInput;

public class ConverterLibrasParaReais implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().multiply(new BigDecimal("6.25"));
	}

	@Override
	public String getSimbolo() {
		return "R$";
	}

	@Override
	public String getFuncao() {
		return "De Libras Para Reais";
	}
}
