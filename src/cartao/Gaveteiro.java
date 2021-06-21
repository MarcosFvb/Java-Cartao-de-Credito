//UTF-8
package cartao;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @since 21/06/2021
 *
 */
public class Gaveteiro {
	
	private Set<FichaCliente> fichas = new HashSet<FichaCliente>();
	
	public Gaveteiro() {
		FichaCliente ficha = new FichaCliente("Cliente 1");
		Cartao cartao = new Vip("123456");
		ficha.add(cartao);
		cartao = new Gold("234567");
		ficha.add(cartao);
		fichas.add(ficha);

		ficha = new FichaCliente("Cliente 2");
		cartao = new Gold("345678");
		ficha.add(cartao);
		cartao = new Platinum("456789");
		ficha.add(cartao);
		fichas.add(ficha);

		ficha = new FichaCliente("Cliente 3");
		cartao = new Gold("567890");
		ficha.add(cartao);
		fichas.add(ficha);
	}

	public Cartao buscar(String numeroCartao) {
		for (FichaCliente ficha : fichas) {
			if (ficha.possuiCartao(numeroCartao)) {
				return ficha.getCartao(numeroCartao);
			}
		}
		return null;
	}

}
