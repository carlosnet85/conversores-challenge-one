package conversor.unidade.metodo.temperatura;

import java.math.BigDecimal;

import conversor.painel.PainelInput;
import conversor.unidade.metodo.moeda.Conversao;

public class ConverterKelvinParaCelsius implements Conversao {
	BigDecimal valorInicial;

	@Override
	public BigDecimal getValorConversao() {
		return new PainelInput().getInput().subtract(new BigDecimal("273.15"));
	}

	@Override
	public String getSimbolo() {
		return "°C";
	}

	@Override
	public String getFuncao() {
		return "De Kelvin a Celsius";
	}
}
