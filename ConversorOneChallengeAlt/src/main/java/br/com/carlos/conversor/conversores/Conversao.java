package br.com.carlos.conversor.conversores;

import br.com.carlos.conversor.elementos.JTextFieldEntrada;

public interface Conversao {
	 Double converter(String unidadeDe, String unidadePara, Double proporcao);
	 String getSimbolo(String unidade);
	 String atualizarTexto(JTextFieldEntrada barraEntrada);
}
