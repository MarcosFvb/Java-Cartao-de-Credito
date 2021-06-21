//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public class Platinum extends Cartao {

	public Platinum(String numero) {
		super(numero, new BigDecimal("10000"));

	}
	
	
	
}
