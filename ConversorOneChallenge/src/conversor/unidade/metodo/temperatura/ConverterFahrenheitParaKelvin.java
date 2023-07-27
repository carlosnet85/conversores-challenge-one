package conversor.unidade.metodo.temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;

import conversor.painel.PainelInput;
import conversor.unidade.metodo.moeda.Conversao;

public class ConverterFahrenheitParaKelvin implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().subtract(new BigDecimal("32")).multiply(new BigDecimal("5")).divide(new BigDecimal("9"), 2, RoundingMode.HALF_UP).add(new BigDecimal("273.15"));
	}

	@Override
	public String getSimbolo() {
		return "K";
	}

	@Override
	public String getFuncao() {
		return "De Fahrenheit a Kelvin";
	}
}
