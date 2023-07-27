package conversor.unidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conversor.unidade.metodo.moeda.Conversao;
import conversor.unidade.metodo.temperatura.ConverterCelsiusParaFahrenheit;
import conversor.unidade.metodo.temperatura.ConverterCelsiusParaKelvin;
import conversor.unidade.metodo.temperatura.ConverterFahrenheitParaCelsius;
import conversor.unidade.metodo.temperatura.ConverterFahrenheitParaKelvin;
import conversor.unidade.metodo.temperatura.ConverterKelvinParaCelsius;
import conversor.unidade.metodo.temperatura.ConverterKelvinParaFahrenheit;

public class ConversorTemperatura {
	protected BigDecimal valor;
	protected String simbolo;

	public ConversorTemperatura() {
		List<Conversao> conversoesTemperatura = new ArrayList<>();
		conversoesTemperatura.add(new ConverterCelsiusParaFahrenheit());
		conversoesTemperatura.add(new ConverterFahrenheitParaCelsius());
		conversoesTemperatura.add(new ConverterCelsiusParaKelvin());
		conversoesTemperatura.add(new ConverterKelvinParaCelsius());
		conversoesTemperatura.add(new ConverterFahrenheitParaKelvin());
		conversoesTemperatura.add(new ConverterKelvinParaFahrenheit());

		String[] opcoes = new String[conversoesTemperatura.size()];
		for (int i = 0; i < conversoesTemperatura.size(); i++) {
			opcoes[i] = conversoesTemperatura.get(i).getFuncao();
		}

		String escolha = (String) JOptionPane.showInputDialog(null,
				"Escolha para qual escala termométrica deseja converter", "Escalas", JOptionPane.PLAIN_MESSAGE, null,
				opcoes, opcoes[0]);

		if (escolha != null) {
			for (Conversao conversao : conversoesTemperatura) {
				if (conversao.getFuncao().equals(escolha)) {
					this.valor = conversao.getValorConversao();
					this.simbolo = conversao.getSimbolo();
					break;
				}
			}

			JOptionPane.showInternalMessageDialog(null, "O valor da conversão é de " + this.valor + this.simbolo);
		}
	}
}