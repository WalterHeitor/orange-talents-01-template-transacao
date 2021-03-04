package br.com.zup.transacao.transacao;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idTransacao;
    private BigDecimal valor;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;
    @Deprecated
	public Transacao() {	}
	public Transacao(String idTransacao, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao) {
		super();
		this.idTransacao = idTransacao;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
	}
	public Long getId() {
		return id;
	}
	public String getIdTransacao() {
		return idTransacao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public Cartao getCartao() {
		return cartao;
	}
	
    

}
