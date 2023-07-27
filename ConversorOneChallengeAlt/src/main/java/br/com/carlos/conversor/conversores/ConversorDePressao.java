package br.com.carlos.conversor.conversores;

import java.util.HashMap;
import java.util.Map;

import br.com.carlos.conversor.elementos.JComboBoxSubUnidadeDe;
import br.com.carlos.conversor.elementos.JComboBoxSubUnidadePara;
import br.com.carlos.conversor.elementos.JTextFieldEntrada;
import br.com.carlos.conversor.funcoes.FormatarResultado;

public class ConversorDePressao implements Conversao {
    private static final Map<String, Double> fatorConversao = new HashMap<>();
    private static final Map<String, String> simbolo = new HashMap<>();
    private JComboBoxSubUnidadeDe listaUnidadeDe = new JComboBoxSubUnidadeDe();
    private JComboBoxSubUnidadePara listaUnidadePara = new JComboBoxSubUnidadePara();

    static {
        fatorConversao.put("Atmosfera", 101325.0);
        fatorConversao.put("Bar", 100000.0);
        fatorConversao.put("Quilopascal", 1000.0);
        fatorConversao.put("Pascal", 1.0);

        simbolo.put("Atmosfera", "atm");
        simbolo.put("Bar", "bar");
        simbolo.put("Quilopascal", "kPa");
        simbolo.put("Pascal", "Pa");
    }

    public ConversorDePressao(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
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
