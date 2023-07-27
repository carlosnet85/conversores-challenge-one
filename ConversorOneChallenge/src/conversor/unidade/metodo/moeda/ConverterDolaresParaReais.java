package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

import conversor.painel.PainelInput;

public class ConverterDolaresParaReais implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().multiply(new BigDecimal("4.73"));
	}

	@Override
	public String getSimbolo() {
		return "R$";
	}

	@Override
	public String getFuncao() {
		return "De Dolares a Reais";
	}
}
