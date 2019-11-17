package projetoUp.dados;
import java.util.ArrayList;

import projetoUp.model.Aeroporto;

public class RepositorioAeroporto {

	private ArrayList<Aeroporto> aeroportos = new ArrayList<>();
	
	public RepositorioAeroporto(ArrayList<Aeroporto> aeroportos)
	{
		
		this.aeroportos = aeroportos;
	}
}
