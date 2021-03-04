package br.com.zup.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idCartao;
	private String email;
	@Deprecated
	public Cartao() {	}
	public Cartao(String idCartao, String email) {
		super();
		this.idCartao = idCartao;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public String getIdCartao() {
		return idCartao;
	}
	public String getEmail() {
		return email;
	}
	
}
