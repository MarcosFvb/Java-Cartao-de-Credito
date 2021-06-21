//UTF-8
package cartao;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @since 21/06/2021
 *
 */
public class FichaCliente {
	
	private String nome;
	
	private Set<Cartao> cartoes = new HashSet<Cartao>();
	
	public FichaCliente(String nome) {
		this.nome = nome;
	}

	public boolean possuiCartao(String numeroCartao) {
		for (Cartao cartao : cartoes) {
			if (cartao.getNumero() == numeroCartao) {
				return true;
			}
		}
		return false;
	}

	public Cartao getCartao(String numeroCartao) {
		for (Cartao cartao : cartoes) {
			if (cartao.getNumero() == numeroCartao) {
				return cartao;
			}
		}
		return null;
	}

	public void add(Cartao cartao) {
		cartoes.add(cartao);
	}

	public String getNome() {
		return nome;
	}
}