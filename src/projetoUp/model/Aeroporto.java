
package projetoUp.model;

public class Aeroporto {
    private String nome;
    private String sigla;
    private String cidade;
    
    public Aeroporto(String nome, String sigla)
    {
    	this.setNome(nome);
    	this.setSigla(sigla);
    }
	
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
	
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
	
	public String getCidade()
	{
		return this.cidade;
	}
	
    
    
}
