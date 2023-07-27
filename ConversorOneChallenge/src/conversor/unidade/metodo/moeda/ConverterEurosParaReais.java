package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

import conversor.painel.PainelInput;

public class ConverterEurosParaReais implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().multiply(new BigDecimal("5.37"));
	}

	@Override
	public String getSimbolo() {
		return "R$";
	}

	@Override
	public String getFuncao() {
		return "De Euros a Reais";
	}
}
