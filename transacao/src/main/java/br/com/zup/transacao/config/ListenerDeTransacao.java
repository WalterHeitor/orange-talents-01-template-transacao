package br.com.zup.transacao.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.cartao.CartaoRepository;
import br.com.zup.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.transacao.EventoDeTransacao;
import br.com.zup.transacao.transacao.Transacao;
import br.com.zup.transacao.transacao.TransacaoRepository;

@Component
public class ListenerDeTransacao {
	
	private TransacaoRepository transacaoRepository;
	private EstabelecimentoRepository estabelecimentoRepository;
	private CartaoRepository cartaoRepository;
	

	 public ListenerDeTransacao(TransacaoRepository transacaoRepository,
			EstabelecimentoRepository estabelecimentoRepository, CartaoRepository cartaoRepository) {
		super();
		this.transacaoRepository = transacaoRepository;
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.cartaoRepository = cartaoRepository;
	}


	@KafkaListener(topics = "${spring.kafka.topic.transactions}",
			 groupId = "${spring.kafka.consumer.group-id}")
	    public void ouvir(EventoDeTransacao eventoDeTransacao) {
		 System.out.println("---------ouvindo----------");
	        System.out.println("--------menssage" + eventoDeTransacao.toString());
	        
	     Transacao transacao = eventoDeTransacao.toModel(estabelecimentoRepository, cartaoRepository);
	    }
}
