
package projetoUp.model;

import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private String sigla;
    private Cidades cidade;
    private ArrayList<Aviao> avioes = new ArrayList<>();
    
    public Aeroporto(String nome, String sigla, Cidades cidade)
    {
    	this.setNome(nome);
    	this.setSigla(sigla);
    	this.setCidade(cidade);
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
	
	public void setCidade(Cidades cidade)
	{
		this.cidade = cidade;
	}
	
	public Cidades getCidade()
	{
		return this.cidade;
	}
	
	public void addAviao()
	{
		this.avioes.add(new Aviao());
	}
	
	public ArrayList<Aviao> listAvioesDisponiveis()
	{
		ArrayList<Aviao> temp = new ArrayList<Aviao>();
		for (Aviao aviao : this.avioes) {
			
			if(aviao.isNoAeroporto())
			{
				temp.add(aviao);
			}
		}
		
		return temp;
	}
	
	public void excluirAviao(Aviao aviao)
	{
		this.avioes.remove(aviao);
	}
	
	public Aviao getAviao()
	{
		for (Aviao aviao : avioes) {
			
			if(aviao.isNoAeroporto())
			{
				return aviao;
			}
		}
		
		this.addAviao();
		return getAviao();
	}


	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroporto other = (Aeroporto) obj;
		if (cidade != other.cidade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	
	
    
    
}
