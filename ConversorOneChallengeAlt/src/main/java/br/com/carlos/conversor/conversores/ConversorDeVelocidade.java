package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDeVelocidade implements Conversao {
    private static final Map<String, Double> fatorConversao = new HashMap<>();
    private static final Map<String, String> simbolo = new HashMap<>();
    private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
    private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

    static {
        fatorConversao.put("Km/s", 1.0);
        fatorConversao.put("M/s", 0.001);
        fatorConversao.put("Km/h", 0.000277778);
        fatorConversao.put("Mm/s", 1000.0);

        simbolo.put("Km/s", "km/s");
        simbolo.put("M/s", "m/s");
        simbolo.put("Km/h", "km/h");
        simbolo.put("Mm/s", "mm/s");
    }

    public ConversorDeVelocidade(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
        this.listaUnidadeDe = listaUnidadeDe;
        this.listaUnidadePara = listaUnidadePara;
    }

    @Override
    public String atualizarTexto(JTextFieldEntrada barraEntrada) {
        Double resultado = converter(listaUnidadeDe.getUnidade(), listaUnidadePara.getUnidade(),
                Double.parseDouble(barraEntrada.getValor()));
        String simbolo = getSimbolo(listaUnidadePara.getUnidade());

        return new FormatarResultado().notacaoCientifica(resultado) + " " + simbolo;
    }

    @Override
    public Double converter(String unidadeDe, String unidadePara, Double proporcao) {
        return proporcao * fatorConversao.get(unidadeDe) / fatorConversao.get(unidadePara);
    }

    @Override
    public String getSimbolo(String unidade) {
        return simbolo.get(unidade);
    }
}
