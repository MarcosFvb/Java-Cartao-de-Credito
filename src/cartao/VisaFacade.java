//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public class VisaFacade implements CartaoFacade {

	@Override
	public boolean receber(String numeroCartao, BigDecimal totalCompra) {
		// 1. encontrar a ficha do cartão
		Gaveteiro gaveteiro = new Gaveteiro();
		Cartao cartao = gaveteiro.buscar(numeroCartao);
		if (cartao == null) {
			throw new CartaoNaoEncontradoException();
		}
		
		// 2. verificar saldo
		if (cartao.getLimite().compareTo(totalCompra) < 0) {
			throw new SaldoInsuficienteException();
		}
		
		// 3. Registrar no cartão a despesa efetuada
		
		// 4. pagar/depositar em conta
		return true;
	}

	@Override
	public BigDecimal saldo(String numeroCartao) {
		return limiteDoCartao(numeroCartao).subtract(quantoAindaPodeGastar(numeroCartao));
	}
	
	
	private BigDecimal limiteDoCartao(String numeroCartao) {
		return BigDecimal.ZERO;

	}
	
	private BigDecimal quantoAindaPodeGastar(String numeroCartao) {
		return BigDecimal.ZERO;
	}

	
	public static void main(String[] args) {
		CartaoFacade empresaCartao = new VisaFacade();
		
		System.out.println(empresaCartao.receber("9234567", new BigDecimal("10200")));
	}
	
}
