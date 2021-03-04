package br.com.zup.transacao.transacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.cartao.CartaoRepository;

@RestController
@RequestMapping("/cartoes")
public class TransacaoController {

	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private CartaoRepository cartaorepository;
	
	@GetMapping("/{id}/transacao")
	public ResponseEntity<?>buscarTransacoes(@PathVariable("id") Long id){
		Optional<Cartao> possivelCartao = cartaorepository.findById(id);
		if(possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoOrderByEfetivadaEmDesc(possivelCartao.get());
		return ResponseEntity.ok(TransacoesResponse.toList(transacoes));
	}

	
}
