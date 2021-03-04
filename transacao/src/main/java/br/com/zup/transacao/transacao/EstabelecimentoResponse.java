package br.com.zup.transacao.transacao;

public class EstabelecimentoResponse {

	private String nome;
	private String cidade;
	private String endereco;
	public EstabelecimentoResponse(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	
}
