package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.zup.transacao.cartao.CartaoRepository;
import br.com.zup.transacao.cartao.EventoCartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import br.com.zup.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.estabelecimento.EventoEstabelecimento;

public class EventoDeTransacao {

	private String id;
    private BigDecimal valor;
    
    private EventoEstabelecimento estabelecimentoEv;
    
    private EventoCartao cartaoEv;

	

	public EventoDeTransacao(String id, BigDecimal valor, EventoEstabelecimento estabelecimentoEv,
			EventoCartao cartaoEv) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimentoEv = estabelecimentoEv;
		this.cartaoEv = cartaoEv;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EventoEstabelecimento getEstabelecimentoEv() {
		return estabelecimentoEv;
	}



	public EventoCartao getCartaoEv() {
		return cartaoEv;
	}



	public Transacao toModel(EstabelecimentoRepository estabelecimentoRepository, CartaoRepository cartaoRepository) {
		Optional<Estabelecimento>  posiivelEstabelecimento = estabelecimentoRepository.findbyNome(estabelecimentoEv.getNome());
		//operador ternario (expressão booleana) ? código 1 : código 2;
		Estabelecimento estabelecimento = posiivelEstabelecimento.isPresent() ? posiivelEstabelecimento.get() :
					new Estabelecimento(estabelecimentoEv.getNome(), estabelecimentoEv.getCidade(), estabelecimentoEv.getEndereco());
		return new Transacao(id, valor, estabelecimento, null);
	}
    
    
	
    
    
}
