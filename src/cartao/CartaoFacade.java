//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public interface CartaoFacade {
	boolean receber(String numeroCartao, BigDecimal totalCompra);
	
	BigDecimal saldo(String numeroCartao);
	
	String donoDoCartao(String numeroCartao);
}