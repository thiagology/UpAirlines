package projetoUp.dados;
import java.util.ArrayList;

import projetoUp.model.Aviao;

public class RepositorioAvioes {

	private ArrayList<Aviao> avioes = new ArrayList<>();
	
	public RepositorioAvioes(ArrayList<Aviao> avioes)
	{
		this.avioes = avioes;
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
		
		return null;
	}
	
}
