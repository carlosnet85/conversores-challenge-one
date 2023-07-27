package br.com.carlos.conversor.funcoes;

public class FormatarResultado {

    public String notacaoCientifica(Double valor) {
    	if (String.valueOf(valor).toLowerCase().contains("e")) {
            String[] partes = String.valueOf(valor).toLowerCase().split("e");
            double base = Double.parseDouble(partes[0]);
            int expoente = Integer.parseInt(partes[1]);
            return String.format("%.2f x 10^%d", base, expoente).replace(".", ",");
        } else {
            return String.valueOf(valor).replace(".", ",");
        }
    }
}
