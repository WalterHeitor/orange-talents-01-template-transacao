package br.com.zup.transacao.cartao;

public class EventoCartao {

	private String id;
	private String email;
	
	public EventoCartao() {	}
	
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public EventoCartao(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	
}
