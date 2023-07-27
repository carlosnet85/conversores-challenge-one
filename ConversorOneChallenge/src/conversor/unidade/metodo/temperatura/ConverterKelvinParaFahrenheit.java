package conversor.unidade.metodo.temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;

import conversor.painel.PainelInput;
import conversor.unidade.metodo.moeda.Conversao;

public class ConverterKelvinParaFahrenheit implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().subtract(new BigDecimal("273.15")).multiply(new BigDecimal("9")).divide(new BigDecimal("5"), 2, RoundingMode.HALF_UP).add(new BigDecimal(32));
	}

	@Override
	public String getSimbolo() {
		return "°F";
	}

	@Override
	public String getFuncao() {
		return "De Kelvin a Fahrenheit";
	}
}
