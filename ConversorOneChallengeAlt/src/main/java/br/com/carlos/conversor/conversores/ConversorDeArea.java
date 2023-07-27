package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDeArea implements Conversao {
    private static final Map<String, Double> fatorConversao = new HashMap<>();
    private static final Map<String, String> simbolo = new HashMap<>();
    private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
    private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

    static {
        fatorConversao.put("Quilômetro quadrado", 1000000.0);
        fatorConversao.put("Hectare", 10000.0);
        fatorConversao.put("Metro quadrado", 1.0);
        fatorConversao.put("Decimetro quadrado", 0.01);
        fatorConversao.put("Centímetro quadrado", 0.0001);
        fatorConversao.put("Milímetro quadrado", 0.000001);

        simbolo.put("Quilômetro quadrado", "km²");
        simbolo.put("Hectare", "ha");
        simbolo.put("Metro quadrado", "m²");
        simbolo.put("Decimetro quadrado", "dm²");
        simbolo.put("Centímetro quadrado", "cm²");
        simbolo.put("Milímetro quadrado", "mm²");
    }

    public ConversorDeArea(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
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
