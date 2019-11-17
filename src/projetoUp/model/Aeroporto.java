
package projetoUp.model;

import java.util.ArrayList;

public class Aeroporto {
    private String nome;
    private String sigla;
    private ArrayList<Aeroporto> adijacentes = new ArrayList();
    
    
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
	
	public void addAeroportoAdj(Aeroporto aeroporto)
	{
		this.adijacentes.add(aeroporto);
	}
	
	
   
    
    
}
