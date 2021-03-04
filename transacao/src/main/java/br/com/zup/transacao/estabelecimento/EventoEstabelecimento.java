package br.com.zup.transacao.estabelecimento;

public class EventoEstabelecimento {

	private String nome;
	private String cidade;
	private String endereco;
	public EventoEstabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventoEstabelecimento(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
    	
}
