package conversor.unidade.metodo.moeda;

import java.math.BigDecimal;

public interface Conversao {
	BigDecimal getValorConversao();
    String getSimbolo();
    String getFuncao();
}
