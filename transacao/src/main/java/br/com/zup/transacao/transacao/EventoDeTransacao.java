package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.cartao.CartaoRepository;
import br.com.zup.transacao.cartao.EventoCartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import br.com.zup.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.estabelecimento.EventoEstabelecimento;

public class EventoDeTransacao {

	private String id;
    private BigDecimal valor;
    private EventoEstabelecimento estabelecimento;
    private EventoCartao cartao;
    private LocalDateTime efetivadaEm;
	

	public EventoDeTransacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public EventoEstabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public EventoCartao getCartao() {
		return cartao;
	}
	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toModel(EstabelecimentoRepository estabelecimentoRepository, CartaoRepository cartaoRepository) {
		Optional<Estabelecimento>  posiivelEstabelecimento = estabelecimentoRepository.findByNome(estabelecimento.getNome());
		//operador ternario (expressão booleana) ? código 1 : código 2;
		Estabelecimento estabelecimento = !posiivelEstabelecimento.isEmpty() ? posiivelEstabelecimento.get() :
					new Estabelecimento(this.estabelecimento.getNome(), this.estabelecimento.getCidade(), this.estabelecimento.getEndereco());
		Optional<Cartao> possivelCartao = cartaoRepository.findByIdCartao(cartao.getId());
		//operador ternario (expressão booleana) ? código 1 : código 2;
		Cartao cartao = !possivelCartao.isEmpty() ? possivelCartao.get() : 
			new Cartao(this.cartao.getId(), this.cartao.getEmail());
		return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
	}

	@Override
	public String toString() {
		return "EventoDeTransacao [id=" + id + ", valor=" + valor + ", estabelecimentoEv=" + estabelecimento
				+ ", cartaoEv=" + cartao + "]";
	}
    
    
	
    
    
}
