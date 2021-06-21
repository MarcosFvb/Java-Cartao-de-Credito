//UTF-8
package cartao;

import java.math.BigDecimal;

/**
 * 
 * @since 21/06/2021
 *
 */
public class VisaFacade implements CartaoFacade {

	private Gaveteiro gaveteiro = new Gaveteiro();
	@Override
	public boolean receber(String numeroCartao, BigDecimal totalCompra) {
		// 1. encontrar a ficha do cartão
		Cartao cartao = gaveteiro.buscar(numeroCartao);
		if (cartao == null) {
			throw new CartaoNaoEncontradoException();
		}
		
		// 2. verificar saldo
		if (cartao.getLimite().compareTo(totalCompra) < 0) {
			throw new SaldoInsuficienteException();
		}
		
		// 3. Registrar no cartão a despesa efetuada
		
		cartao.adicionaCompra(totalCompra);
		
		// 4. pagar/depositar em conta
		return true;
	}

	@Override
	public BigDecimal saldo(String numeroCartao) {
		Cartao cartao = gaveteiro.buscar(numeroCartao);
		return cartao.checarSaldo();
	}
	
	
	public static void main(String[] args) {
		CartaoFacade empresaCartao = new VisaFacade();
		
		System.out.println(empresaCartao.receber("234567", new BigDecimal("300")));
		System.out.println(empresaCartao.receber("234567", new BigDecimal("200")));
		
		System.out.println(empresaCartao.saldo("234567"));
		System.out.println(empresaCartao.donoDoCartao("234567"));
	}

	@Override
	public String donoDoCartao(String numeroCartao) {
		FichaCliente ficha = gaveteiro.buscarFicha(numeroCartao);
		return ficha.getNome();
	}
	
}
