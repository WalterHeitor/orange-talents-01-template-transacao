package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacoesResponse {

	private BigDecimal valor;
	private LocalDateTime efetivadaEm;
	private EstabelecimentoResponse estabelecimento;

	public TransacoesResponse(BigDecimal valor, LocalDateTime efetivadaEm, EstabelecimentoResponse estabelecimento) {
		super();
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.estabelecimento = estabelecimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}
	public TransacoesResponse(Transacao transacao) {
		super();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento().getNome(),
				                                           transacao.getEstabelecimento().getCidade(),
				                                           transacao.getEstabelecimento().getEndereco());
	}

	public static List<TransacoesResponse> toList(List<Transacao> transacoes) {
		List<TransacoesResponse> listTransacoes = new ArrayList<>();
		for(Transacao transacao : transacoes) {
			TransacoesResponse response = new TransacoesResponse(transacao);
			listTransacoes.add(response);	
		}
	return listTransacoes;
	}

}
