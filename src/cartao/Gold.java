//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public class Gold extends Cartao {

	public Gold(String numero) {
		super(numero, new BigDecimal("5000"));
	}

}
