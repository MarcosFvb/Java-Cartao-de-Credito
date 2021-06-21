//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public abstract class Cartao {

	private String numero;
	private BigDecimal limite;
	private BigDecimal extrato = BigDecimal.ZERO;

	public Cartao(String numero, BigDecimal limite) {
		this.numero = numero;
		this.limite = limite;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void adicionaCompra(BigDecimal totalCompra) {
		this.extrato = extrato.add(totalCompra);	
	}

	public BigDecimal checarSaldo() {
		return limite.subtract(extrato);
	}

}