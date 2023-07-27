package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDeVolume implements Conversao {
    private static final Map<String, Double> fatorConversao = new HashMap<>();
    private static final Map<String, String> simbolo = new HashMap<>();
    private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
    private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

    static {
        fatorConversao.put("Mililitro", 1.0);
        fatorConversao.put("Centilitro", 10.0);
        fatorConversao.put("Litro", 1000.0);
        fatorConversao.put("Metro cúbico", 1000000.0);
        fatorConversao.put("Decilitro", 100.0);
        fatorConversao.put("Centímetro cúbico", 1.0);

        simbolo.put("Mililitro", "mL");
        simbolo.put("Centilitro", "cL");
        simbolo.put("Litro", "L");
        simbolo.put("Metro cúbico", "m³");
        simbolo.put("Decilitro", "dL");
        simbolo.put("Centímetro cúbico", "cm³");
    }

    public ConversorDeVolume(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
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
