package conversor.unidade.metodo.temperatura;

import java.math.BigDecimal;

import conversor.painel.PainelInput;
import conversor.unidade.metodo.moeda.Conversao;

public class ConverterCelsiusParaKelvin implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().add(new BigDecimal("273.15"));
	}

	@Override
	public String getSimbolo() {
		return "K";
	}

	@Override
	public String getFuncao() {
		return "De Celsius a Kelvin";
	}
}
