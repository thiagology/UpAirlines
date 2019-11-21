package projetoUp.dados;
import java.util.ArrayList;

import projetoUp.model.Aviao;

public class RepositorioAvioes {

	
	
	public RepositorioAvioes(ArrayList<Aviao> avioes)
	{
		this.avioes = avioes;
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
	
	
	
	
	
}
