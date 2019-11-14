
package projetoUp.model;


public class Aeroporto {
    private String nome;
    private String sigla;
    private int fuso;
    private Cidade cidade;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public int getFuso() {
		return fuso;
	}
	public void setFuso(int fuso) {
		this.fuso = fuso;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
   
    
    
}
