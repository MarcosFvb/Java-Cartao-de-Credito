//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public class Vip extends Cartao {

	public Vip(String numero) {
		super(numero, new BigDecimal("1000"));
	}


}
